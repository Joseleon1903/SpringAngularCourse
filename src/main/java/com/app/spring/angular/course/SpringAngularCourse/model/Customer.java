package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by jose de leon on 4/27/2021.
 */
@Data
@Entity(name = "Customer")
@Table(name = "Customer",
        uniqueConstraints = {
                @UniqueConstraint(name = "customer_code_unique", columnNames = "customer_code")

        })
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName ="customer_sequence" ,
            allocationSize =1)
    private Long id;

    @Column(name = "customer_code", nullable = false)
    private String customerCode;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    //private List<Order> orders;
}
