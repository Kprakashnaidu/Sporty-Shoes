package com.sportyshoes.controller;

import com.sportyshoes.entity.OrderEntity;
import com.sportyshoes.entity.ProductEntity;
import com.sportyshoes.entity.UserEntity;
import com.sportyshoes.service.OrderService;
import com.sportyshoes.service.ProductService;
import com.sportyshoes.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final OrderService orderService;
    private final UserService userService;

    @GetMapping("all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String findAll(Model model) {

        final List<ProductEntity> products = productService.findAll();

        model.addAttribute("products", products);
        return "view-stock";
    }

    @GetMapping("add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addStock(ProductEntity productEntity) {

        return "add-stock";
    }

    //    public String addStock(@Valid ProductEntity productEntity, BindingResult bindingResult) {
    @PostMapping("add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addStock(@RequestParam MultipartFile image,
                           @RequestParam String name,
                           @RequestParam String styleName,
                           @RequestParam String brand,
                           @RequestParam String color,
                           @RequestParam Integer stock,
                           @RequestParam String suitableFor,
                           @RequestParam String type,
                           @RequestParam Double price,
                           @RequestParam String description) throws IOException {

        ProductEntity productEntity = new ProductEntity(name, styleName, brand, color, stock + 0, 0,
                suitableFor, type, price, description, image.getBytes(), new Date());

        productService.save(productEntity);
        return "redirect:all?add-product=true";
    }

    @GetMapping("view/{id}")
    public String viewProduct(@PathVariable Integer id, Model model) {

        final ProductEntity product = productService.findById(id).get();

        model.addAttribute("product", product);
        model.addAttribute("id", product.getId());
        return "view-product";
    }

    @PostMapping("update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateProduct(@PathVariable Integer id,
                                @RequestParam MultipartFile image,
                                @RequestParam String name,
                                @RequestParam String styleName,
                                @RequestParam String brand,
                                @RequestParam String color,
                                @RequestParam Integer stock,
                                @RequestParam Integer sold,
                                @RequestParam String suitableFor,
                                @RequestParam String type,
                                @RequestParam Double price,
                                @RequestParam String description) throws IOException {

        ProductEntity product = productService.findById(id).get();

        product.setImage(image.getBytes())
                .setName(name)
                .setStyleName(styleName)
                .setBrand(brand)
                .setColor(color)
                .setStock(stock)
                .setSold(sold + 0)
                .setSuitableFor(suitableFor)
                .setType(type)
                .setPrice(price)
                .setDescription(description);

//        if (result.hasErrors()) {
//            product.setId(id);
//            return "view-product";
//        }

        productService.save(product);
        return "redirect:/product/all?product-update=true";
    }

    @GetMapping("delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteById(id);
        return "redirect:/product/all?delete-product=true";
    }

    @GetMapping("view/{suitableFor}/{type}/{id}")
    public String viewSuitableAndTypeShoes(@PathVariable String suitableFor,
                                           @PathVariable String type,
                                           @PathVariable Integer id,
                                           Model model) {

        suitableFor = StringUtils.capitalize(suitableFor);
        type = StringUtils.capitalize(type);

        ProductEntity product = new ProductEntity();

        if (suitableFor.equalsIgnoreCase("brand"))
            product = productService.findByIdAndBrand(type, id);
        else
            product = productService.findByIdAndSuitableForAndType(suitableFor, type, id);

        model.addAttribute("product", product);
        model.addAttribute("id", id);

        return "buy-product";
    }

    @GetMapping("all/{suitableFor}")
    public String allShoes(@PathVariable String suitableFor, Model model) {

        suitableFor = StringUtils.capitalize(suitableFor);

        String heading = suitableFor + " Shoes";
        String title = heading + " | Sporty Shoes";

        List<ProductEntity> productEntities = new ArrayList<>();

        if (suitableFor.equalsIgnoreCase("brand")) {
            productEntities = productService.findAll();
            heading = "All " + heading;
            title = "All " + title;
        } else
            productEntities = productService.findAllBySuitableFor(suitableFor);

        model.addAttribute("suitableFor", suitableFor);
        model.addAttribute("title", title);
        model.addAttribute("heading", heading);
        model.addAttribute("products", productEntities);

        return "all-products";
    }

    @GetMapping("all/{suitableFor}/{type}")
    public String allShoeTypes(@PathVariable String suitableFor, @PathVariable String type, Model model) {

        suitableFor = StringUtils.capitalize(suitableFor);
        type = StringUtils.capitalize(type);

        String heading = suitableFor + " " + type + " Shoes";
        String title = heading + " | Sporty Shoes";

        List<ProductEntity> productEntities = new ArrayList<>();

        if (suitableFor.equalsIgnoreCase("brand")) {
            productEntities = productService.findByBrand(type);
            heading = type + " Shoes";
            title = heading + " | Sporty Shoes";
        } else
            productEntities = productService.findAllBySuitableForAndType(suitableFor, type);

        model.addAttribute("suitableFor", suitableFor);
        model.addAttribute("title", title);
        model.addAttribute("heading", heading);
        model.addAttribute("products", productEntities);

        return "all-products";
    }

    @GetMapping("/buy/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public String buyShoes(@PathVariable Integer id, HttpServletRequest request) throws InterruptedException {

        final ProductEntity productEntity = productService.findById(id).get();

//        If we save the list as Arrays.asList(productEntity); we get error,
//        because the list with Arrays.asList() is unmodified so we have to use the below approach
        List<ProductEntity> products = new ArrayList<>();
        products.add(productEntity);

        final String name = request.getUserPrincipal().getName();

        UserEntity userEntity = userService.findByEmail(name).get();

        final OrderEntity orderEntity = new OrderEntity(productEntity.getPrice(), true, products, userEntity);
        orderService.save(orderEntity);

        List<OrderEntity> orders = new ArrayList<>();
        orders.add(orderEntity);
        orders.addAll(productEntity.getOrderEntities());

        productEntity.setId(id)
                .setOrderEntities(orders)
                .setSold(productEntity.getSold() + 1)
                .setStock(productEntity.getStock() - 1);

        productService.save(productEntity);
        final String uri = request.getHeader("Referer");

        return "redirect:" + uri + "?order=true";
    }
}
