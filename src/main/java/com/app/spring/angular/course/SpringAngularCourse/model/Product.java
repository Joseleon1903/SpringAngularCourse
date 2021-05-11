package com.app.spring.angular.course.SpringAngularCourse.model;

import com.app.spring.angular.course.SpringAngularCourse.mapper.ProductSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by jose de leon on 4/27/2021.
 */
@JsonSerialize(using = ProductSerializer.class)
@Data
@Entity(name = "Product")
@Table(name = "Product",
        uniqueConstraints = {
                @UniqueConstraint(name = "product_code_unique", columnNames = "product_code")
        })
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName ="product_sequence" ,
            allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_sequence")
    @Column(name = "product_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToOne
    private Category category;

    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "discount_percent", nullable = false)
    private Double discountPercent;

    @Column(name = "image_path", nullable = false)
    private String imagePath;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "review_id", referencedColumnName = "review_id")
    private Review review;

    public Product(){}

    public Product(Long id, String name, String description, Category category, String productCode, Double price, Double discountPercent, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.productCode = productCode;
        this.price = price;
        this.discountPercent = discountPercent;
        this.imagePath = imagePath;
    }
}
