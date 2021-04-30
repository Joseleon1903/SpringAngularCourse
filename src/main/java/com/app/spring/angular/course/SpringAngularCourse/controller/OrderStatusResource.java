package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.model.OrderStatus;
import com.app.spring.angular.course.SpringAngularCourse.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jose de leon on 4/30/2021.
 */
@RestController
@RequestMapping("/order/status")
public class OrderStatusResource {

    private final OrderStatusService orderStatusService;

    @Autowired
    public OrderStatusResource(OrderStatusService orderStatusService){
        this.orderStatusService = orderStatusService;
    }

    @GetMapping
    public ResponseEntity<List<OrderStatus>> getProducts(){
        List<OrderStatus> ordersStatus = orderStatusService.findAllOrderStatus();
        return ResponseEntity.ok(ordersStatus);
    }






}
