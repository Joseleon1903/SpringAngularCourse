package com.app.spring.angular.course.SpringAngularCourse.service;

import com.app.spring.angular.course.SpringAngularCourse.jparepository.OrderStatusRepository;
import com.app.spring.angular.course.SpringAngularCourse.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jose de leon on 4/30/2021.
 */
@Service
public class OrderStatusService {

    private final OrderStatusRepository orderStatusRepository;

    @Autowired
    public OrderStatusService(OrderStatusRepository orderStatusRepository){
        this.orderStatusRepository= orderStatusRepository;
    }

    public List<OrderStatus> findAllOrderStatus() {
        return orderStatusRepository.findAll();
    }
}
