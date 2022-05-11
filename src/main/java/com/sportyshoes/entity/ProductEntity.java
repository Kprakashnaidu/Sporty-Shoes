package com.sportyshoes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
@DynamicUpdate
@DynamicInsert
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity implements Serializable {

    @Id
//    @GeneratedValue(generator = "uuid", strategy = GenerationType.AUTO)
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max = 30, message = "Product name must be min 3 and max 30 characters")
    @NotEmpty(message = "Please enter product name")
    private String name;

    @Size(min = 3, max = 30, message = "Product style name must be min 3 and max 30 characters")
    @NotEmpty(message = "Please enter style name")
    @Column(name = "style_name")
    private String styleName;

    @Size(min = 3, max = 30, message = "Brand name must be min 3 and max 30 characters")
    @NotEmpty(message = "Please enter brand name")
    private String brand;

    @Size(min = 3, max = 30, message = "Product color must be min 3 and max 30 characters")
    @NotEmpty(message = "Please enter product color")
    private String color;

    //    @Min(value = 1, message = "Stock must be min 1")
    private Integer stock;

    private Integer sold;

    @Size(min = 3, max = 30, message = "Suitable must be min 3 and max 30 characters")
    @NotEmpty(message = "Please select suitable for")
    @Column(name = "suitable_for")
    private String suitableFor;

    @Size(min = 3, max = 30, message = "Product type must be min 3 and max 30 characters")
    @NotEmpty(message = "Please enter product type")
    private String type;

    @Min(value = 100, message = "Price must be min 100")
    private Double price;

    @Size(min = 3, max = 1000, message = "Product description must be min 3 and max 1000 characters")
    @NotEmpty(message = "Please enter product description")
    @Column(length = 1000)
    private String description;

//    @Transient
//    private String file;

    @Lob
    @Column(length = Integer.MAX_VALUE)
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate = new Date();

    //    @ManyToOne(cascade = CascadeType.ALL, targetEntity = OrderEntity.class, fetch = FetchType.LAZY)
    //    @JoinColumn(name = "order_id")
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = OrderEntity.class)
    @JoinTable(
            name = "orders_products",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id")}
    )
    private List<OrderEntity> orderEntities;

    public ProductEntity(String name,
                         String styleName,
                         String brand,
                         String color,
                         Integer stock, Integer sold,
                         String suitableFor,
                         String type,
                         Double price,
                         String description,
                         byte[] image,
                         Date createDate) {
        this.name = name;
        this.styleName = styleName;
        this.brand = brand;
        this.color = color;
        this.stock = stock;
        this.sold = sold;
        this.suitableFor = suitableFor;
        this.type = type;
        this.price = price;
        this.description = description;
        this.image = image;
        this.createDate = createDate;
    }

    public static String bytesToImageConverter(byte[] imageInBytes) {

        return imageInBytes != null && imageInBytes.length > 0 ? Base64.getEncoder().encodeToString(imageInBytes) : "";
    }

    public ProductEntity setName(String name) {
        this.name = name;
        return this;
    }

    public ProductEntity setStyleName(String styleName) {
        this.styleName = styleName;
        return this;
    }

    public ProductEntity setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public ProductEntity setColor(String color) {
        this.color = color;
        return this;
    }

    public ProductEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public ProductEntity setStock(Integer stock) {
        this.stock = stock;
        return this;
    }

    public ProductEntity setSold(Integer sold) {
        this.sold = sold;
        return this;
    }

    public ProductEntity setSuitableFor(String suitableFor) {
        this.suitableFor = suitableFor;
        return this;
    }

    public ProductEntity setType(String type) {
        this.type = type;
        return this;
    }

    public ProductEntity setPrice(Double price) {
        this.price = price;
        return this;
    }

    public ProductEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductEntity setImage(byte[] image) {
        this.image = image;
        return this;
    }

    public ProductEntity setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public ProductEntity setOrderEntities(List<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
        return this;
    }
}
