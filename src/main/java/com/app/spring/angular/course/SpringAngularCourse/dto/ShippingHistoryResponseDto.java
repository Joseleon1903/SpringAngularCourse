package com.app.spring.angular.course.SpringAngularCourse.dto;

import com.app.spring.angular.course.SpringAngularCourse.model.CardType;
import com.app.spring.angular.course.SpringAngularCourse.model.PaymentType;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by jose de leon on 6/20/2021.
 */
@Data
public class ShippingHistoryResponseDto {

    private String orderCode;
    private String orderNumber;
    private LocalDateTime creationDate;
    private String status;
    private String customerCode;
    private String employeeCode;
    private BigDecimal totalPrice;
    private CardType cardType;
    private PaymentType paymentType;
    private String shippingCode;
    private LocalDateTime deliveryDate;
    private String destinationName;


    public ShippingHistoryResponseDto(String orderCode, String orderNumber, LocalDateTime creationDate, String status) {
        this.orderCode = orderCode;
        this.orderNumber = orderNumber;
        this.creationDate = creationDate;
        this.status = status;
    }

    public ShippingHistoryResponseDto(String orderCode, String orderNumber, LocalDateTime creationDate,
                                      String status, String customerCode,String employeeCode, BigDecimal totalPrice,
                                      CardType cardType, PaymentType paymentType, String shippingCode, LocalDateTime deliveryDate,
                                      String destinationName) {
        this.orderCode = orderCode;
        this.orderNumber = orderNumber;
        this.creationDate = creationDate;
        this.status = status;
        this.customerCode = customerCode;
        this.employeeCode = employeeCode;
        this.totalPrice = totalPrice;
        this.cardType = cardType;
        this.paymentType = paymentType;
        this.shippingCode = shippingCode;
        this.deliveryDate = deliveryDate;
        this.destinationName = destinationName;
    }
}