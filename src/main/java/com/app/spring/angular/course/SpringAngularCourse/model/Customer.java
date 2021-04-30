package com.app.spring.angular.course.SpringAngularCourse.model;

import com.app.spring.angular.course.SpringAngularCourse.mapper.CustomerSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by jose de leon on 4/27/2021.
 */
@JsonSerialize(using = CustomerSerializer.class)
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence")
    @Column(name = "customer_id", nullable = false)
    private Long id = 0L;

    @Column(name = "customer_code", nullable = false)
    private String customerCode;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "address", nullable = false)
    private String address;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "birthday")
    private Date birthday;

    @OneToOne(mappedBy = "customer")
    private User user;

    public Customer (){}


//private List<CustomerOrder> orders;
}
