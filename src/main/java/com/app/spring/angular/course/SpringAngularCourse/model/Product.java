package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jose de leon on 4/27/2021.
 */
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

}
