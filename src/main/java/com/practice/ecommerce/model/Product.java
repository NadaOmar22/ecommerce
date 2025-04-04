package com.practice.ecommerce.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private BigDecimal salePrice;
    private BigDecimal costPrice;

    @ManyToOne
    @JoinColumn(name = "category")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Category category;
}

