package com.app.spring.angular.course.SpringAngularCourse.service;

import com.app.spring.angular.course.SpringAngularCourse.jparepository.CustomerOrderRepository;
import com.app.spring.angular.course.SpringAngularCourse.model.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jose de leon on 5/4/2021.
 */
@Service
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;

    @Autowired
    public CustomerOrderService(CustomerOrderRepository customerOrderRepository){
        this.customerOrderRepository = customerOrderRepository;
    }

    public List<CustomerOrder> findAllCustomerOrders() {
        return (List<CustomerOrder>) customerOrderRepository.findAll();
    }

    public CustomerOrder findCustomerOrdersByCode(String code) {
        return customerOrderRepository.findByOrderCode(code).get();
    }

}
