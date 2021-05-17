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

    @Enumerated
    @Column(name = "payment_type", nullable = false)
    private PaymentType paymentType;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_type", nullable = false)
    private CardType cardType;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "card_holder_name", nullable = false)
    private String cardHolderName;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "expire_date", nullable = false)
    private String expireDate;

    @Column(name = "comment", nullable = false)
    private String comment;

}
