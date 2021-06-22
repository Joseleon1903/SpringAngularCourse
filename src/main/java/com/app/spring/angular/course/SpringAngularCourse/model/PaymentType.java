package com.app.spring.angular.course.SpringAngularCourse.model;

/**
 * Created by jose de leon on 4/27/2021.
 */
public enum PaymentType {

    CREDIT_CARD(2),
    DEBIT_CARD(1),
    CASH(3);

    private final int paymentType;

    PaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public int getPaymentType() {
        return this.paymentType;
    }

}
