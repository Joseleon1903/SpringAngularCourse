package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by jose de leon on 8/16/2021.
 */
@Data
@Entity(name = "MoonProduct")
@Table(name = "moon_product")
public class MoonProduct {

    @Id
    @SequenceGenerator(
            name = "moon_product_sequence",
            sequenceName ="moon_product_sequence" ,
            allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "moon_product_sequence")
    @Column(name = "moon_product_id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @OneToOne
    private Category category;

    @Column(name = "urlImage", nullable = false)
    private String urlImage;

}
