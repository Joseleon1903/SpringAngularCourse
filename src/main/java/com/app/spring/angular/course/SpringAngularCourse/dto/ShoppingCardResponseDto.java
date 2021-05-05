package com.app.spring.angular.course.SpringAngularCourse.dto;

import lombok.Data;

/**
 * Created by jose de leon on 5/3/2021.
 */
@Data
public class ShoppingCardResponseDto {

    private String orderCode;

    private String orderNumber;

    private ProductDto[] products;

    private String status;

    private Double productTotalPrice;

    private Double taxCharge;

    private Double totalPrice;

}
