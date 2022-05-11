package com.sportyshoes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "orders")
@DynamicUpdate
@DynamicInsert
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bill_amount")
    private Double billAmount;

    @Column(name = "bill_paid")
    private Boolean billPaid;

    //    @OneToMany(cascade = CascadeType.ALL, targetEntity = ProductEntity.class, fetch = FetchType.LAZY, mappedBy = "orderEntity")
    @ToString.Exclude
    @ManyToMany(mappedBy = "orderEntities", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ProductEntity.class)
    private List<ProductEntity> products;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public OrderEntity(Double billAmount, Boolean billPaid, List<ProductEntity> products, UserEntity userEntity) {
        this.billAmount = billAmount;
        this.billPaid = billPaid;
        this.products = products;
        this.userEntity = userEntity;
    }
}
