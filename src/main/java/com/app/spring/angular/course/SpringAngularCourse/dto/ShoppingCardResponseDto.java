package com.app.spring.angular.course.SpringAngularCourse.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by jose de leon on 5/3/2021.
 */
@Data
public class ShoppingCardResponseDto {

    private String orderCode;

    private String orderNumber;

    private ProductDto[] products;

    private String status;

    private BigDecimal productTotalPrice;

    private BigDecimal taxCharge;

    private BigDecimal totalPrice;

}
