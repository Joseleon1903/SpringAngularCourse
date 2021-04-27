package com.app.spring.angular.course.SpringAngularCourse.model;

import java.util.List;

/**
 * Created by jose de leon on 4/27/2021.
 */
public class OrderDetail {

    private Long id;

    private String description;

    private List<Product> productList;

    private Double productTotalprice;

    private Double taxCaharge;

    private Double totalPrice;

    private Double discount;

    private PaymentInfo paymentInfo;

}
