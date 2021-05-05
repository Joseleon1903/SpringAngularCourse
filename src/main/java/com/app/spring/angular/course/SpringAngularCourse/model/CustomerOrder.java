package com.app.spring.angular.course.SpringAngularCourse.model;

import com.app.spring.angular.course.SpringAngularCourse.mapper.CustomerOrderSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by jose de leon on 4/27/2021.
 */
@JsonSerialize(using = CustomerOrderSerializer.class)
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

    @Column(name = "order_number", nullable = false)
    private String orderNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    @JoinColumn(name="order_detail_id")
    private OrderDetail orderDetail;

    @CreationTimestamp
    @Column(name = "creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @CreationTimestamp
    @Column(name = "last_update_date", nullable = false)
    private LocalDateTime lastUpdateDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="shipping_detail_id")
    private ShippingDetail shippingDetail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="order_status_id", nullable=false)
    private OrderStatus orderStatus;

}
