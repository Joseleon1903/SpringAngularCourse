package com.app.spring.angular.course.SpringAngularCourse.dto;

import lombok.Data;

/**
 * Created by jose de leon on 5/3/2021.
 */
@Data
public class ShoppingCardPreviewDto {

    private String orderCode;

    private String orderNumber;

    private Long customerId;

    private Long employeeId;

    private Long productId;

    private Long orderStatusId;

}
