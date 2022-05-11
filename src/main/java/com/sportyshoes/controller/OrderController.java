package com.sportyshoes.controller;

import com.sportyshoes.entity.OrderEntity;
import com.sportyshoes.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("all")
    @PreAuthorize("hasAuthority('UPDATE')")
    public String findAll(Model model) {

        final List<OrderEntity> orders = orderService.findAll();

        model.addAttribute("orders", orders);
        return "view-orders";
    }

    @GetMapping("view/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public String viewOrder(@PathVariable Integer id, Model model) {

        final OrderEntity orderEntity = orderService.findById(id).get();

        /*
        * final Map<Integer, String> details = orderEntity.getProducts()
                .stream()
                .collect(Collectors.toMap(ProductEntity::getId, ProductEntity::getName));
        * */
        model.addAttribute("order", orderEntity);
//        model.addAttribute("products", orderEntity.getProducts());
        return "order-details";
    }
}
