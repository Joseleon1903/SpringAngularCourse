package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by jose de leon on 4/27/2021.
 */
@Data
@Entity(name = "Category")
@Table(name = "Category",
        uniqueConstraints = {
                @UniqueConstraint(name = "category_code_unique", columnNames = "code"),
                @UniqueConstraint(name = "category_name_unique", columnNames = "name")
        })
public class Category {

    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName ="category_sequence" ,
            allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "category_sequence")
    @Column(name = "id" , updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "status", nullable = false)
    private boolean isActive;

    @Column(name = "app_name", nullable = false)
    private String appName;

    public Category(){}

    public Category(Long id) {
        this.id = id;
    }

    public Category(Long id, String name, String code, boolean isActive) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.isActive = isActive;
    }
}
