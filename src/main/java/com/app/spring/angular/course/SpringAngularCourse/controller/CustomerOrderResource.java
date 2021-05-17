package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.model.CustomerOrder;
import com.app.spring.angular.course.SpringAngularCourse.service.CustomerOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by jose de leon on 5/4/2021.
 */
@RestController
@RequestMapping("/customer/order")
public class CustomerOrderResource {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CustomerOrderService customerOrderService;

    @Autowired
    public CustomerOrderResource(CustomerOrderService customerOrderService){
        this.customerOrderService = customerOrderService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerOrder>> getAllCustomers(){
        Pageable pageable = PageRequest.of(0,100, Sort.by("id").descending());
        List<CustomerOrder> customers = customerOrderService.findAllCustomerOrders(pageable);
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/paginate")
    public ResponseEntity<List<CustomerOrder>> getAllCustomersPage(@RequestParam("page") int page,
                                                               @RequestParam("size") int size){
        Pageable pageable = PageRequest.of(page,size, Sort.by("id").descending());
        List<CustomerOrder> customers = customerOrderService.findAllCustomerOrders(pageable);
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/search")
    public ResponseEntity<CustomerOrder> getCustomerOrderByCode(@RequestParam("customerOrderCode") String code){
        CustomerOrder customerOrder = customerOrderService.findCustomerOrdersByCode(code);
        return ResponseEntity.ok(customerOrder);
    }

}