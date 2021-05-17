package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by jose de leon on 5/17/2021.
 */
@Data
@Entity(name = "TransactionHistory")
@Table(name = "Transaction_History",
        uniqueConstraints = {
                @UniqueConstraint(name = "transaction_history_code_unique", columnNames = "transaction_code")
        }
)
public class TransactionHistory {

    @Id
    @SequenceGenerator(
            name = "transaction_history_sequence",
            sequenceName ="transaction_history_sequence" ,
            allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "transaction_history_sequence")
    @Column(name = "transaction_history_id", nullable = false)
    private Long id;

    @Column(name ="transaction_code", nullable = false)
    private String code;

    @CreationTimestamp
    @Column(name ="transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    @Column(name ="status", nullable = false)
    private String status;

    @Column(name ="amount", nullable = false)
    private BigDecimal amount;

    @Column(name ="user_debt", nullable = false)
    private String userDebt;

    @Column(name ="user_receive", nullable = false)
    private String userReceive;

}
