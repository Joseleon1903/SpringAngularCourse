package com.app.spring.angular.course.SpringAngularCourse.dto;

import lombok.Data;

/**
 * Created by jose de leon on 5/4/2021.
 */
@Data
public class ShippingRequestDto {

    private String orderCode;

    private String orderNumber;

    private String shippingCode;

    private Long destinationId;

    private String destinationName;

    private String deliveryDate;

}
