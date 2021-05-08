package com.app.spring.angular.course.SpringAngularCourse.dto;

import lombok.Data;

/**
 * Created by jose de leon on 5/4/2021.
 */
@Data
public class PaymentRequestDto {

    private String orderCode;

    public Integer paymentType;

    public Integer cardType;

    private String cardNumber;

    private String cardHolderName;

    private String accountNumber;

    private String expireDate;

    private String comment;

}
