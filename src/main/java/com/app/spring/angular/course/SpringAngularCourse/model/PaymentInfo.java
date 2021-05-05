package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by jose de leon on 4/27/2021.
 */
@Data
@Entity(name = "Payment_info")
@Table(name = "Payment_info")
public class PaymentInfo {

    @Id
    @SequenceGenerator(
            name = "payment_info_id",
            sequenceName ="payment_info_id" ,
            allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "payment_info_id")
    @Column(name = "payment_info_id", nullable = false)
    private long id;

    private PaymentType paymentType;

    private CardType cardType;

    private String cardNumber;

    private String cardHolderName;

    private String accountNumber;

    private String expireDate;

    private String comment;

}
