package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by jose de leon on 4/27/2021.
 */
@Data
@Entity(name = "Customer_Order")
@Table(name =  "Customer_Order", uniqueConstraints = {
        @UniqueConstraint(name = "customer_order_code_unique", columnNames = "order_code")
} )
public class CustomerOrder {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName ="order_sequence" ,
            allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "order_sequence")
    @Column(name = "order_id", nullable = false)
    private Long id;

    @Column(name = "order_code", nullable = false)
    private String orderCode;

    private String orderNumber;

//    private Customer customer;
//
//    private Employee employee;
//
//    private OrderDetail orderDetail;
//
    @CreationTimestamp
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @CreationTimestamp
    @Column(name = "last_update_date", nullable = false)
    private LocalDateTime lastUpdateDate;
//
//    private ShippingDetail shippingDetail;
//
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="order_status_id", nullable=false)
    private OrderStatus orderStatus;

}
