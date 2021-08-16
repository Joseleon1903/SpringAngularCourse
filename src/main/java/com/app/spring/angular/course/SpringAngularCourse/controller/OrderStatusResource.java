package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.model.OrderStatus;
import com.app.spring.angular.course.SpringAngularCourse.service.LoggerService;
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
public class OrderStatusResource implements IResourceController {

    private final OrderStatusService orderStatusService;

    private final LoggerService loggerService;

    @Autowired
    public OrderStatusResource(OrderStatusService orderStatusService, LoggerService loggerService){
        this.orderStatusService = orderStatusService;
        this.loggerService = loggerService;
    }

    @GetMapping
    public ResponseEntity<List<OrderStatus>> getAllOrderStatus(){
        loggerService.putLogDatabase(String.format("Request call GET getAllOrderStatus"),this, "OrderStatusService" );
        List<OrderStatus> ordersStatus = orderStatusService.findAllOrderStatus();
        return ResponseEntity.ok(ordersStatus);
    }


}
