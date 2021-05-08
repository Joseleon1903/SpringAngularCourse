package com.app.spring.angular.course.SpringAngularCourse.model;

/**
 * Created by jose de leon on 4/27/2021.
 */
public enum CardType {

    VISA(1), MASTERCARD(2);

    private final int cardType;

    CardType(int cardType) {
        this.cardType = cardType;
    }

    public int getCardType() {
        return this.cardType;
    }
}
