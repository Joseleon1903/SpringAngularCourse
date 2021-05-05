package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by jose de leon on 4/27/2021.
 */
@Data
@Entity(name = "Order_status")
@Table(name =  "Order_status")
public class OrderStatus {

    @Id
    @SequenceGenerator(
            name = "order_status_sequence",
            sequenceName ="order_status_sequence" ,
            allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "order_status_sequence")
    @Column(name = "order_status_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    public OrderStatus(){}

    public OrderStatus(Long orderStatusId){
        this.id = orderStatusId;
    }
}
