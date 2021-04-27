package com.app.spring.angular.course.SpringAngularCourse.model;

import java.util.Date;

/**
 * Created by jose de leon on 4/27/2021.
 */
public class Order {

    private Long id;

    private String orderCode;

    private Customer customer;

    private Employee employee;

    private OrderDetail orderDetail;

    private Date creationDay;

    private ShippingDetail shippingDetail;

    private OrderStatus status;

}
