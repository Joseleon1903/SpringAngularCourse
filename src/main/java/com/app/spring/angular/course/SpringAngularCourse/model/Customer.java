package com.app.spring.angular.course.SpringAngularCourse.model;

import java.util.List;

/**
 * Created by jose de leon on 4/27/2021.
 */
public class Customer {

    private Long id;

    private String customerCode;

    private String firstName;

    private String lastName;

    private String address;

    private String birthday;

    private String email;

    private List<Order> orders;
}
