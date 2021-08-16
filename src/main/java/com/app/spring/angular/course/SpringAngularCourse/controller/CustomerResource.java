package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.model.Customer;
import com.app.spring.angular.course.SpringAngularCourse.service.CustomerService;
import com.app.spring.angular.course.SpringAngularCourse.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by jose de leon on 4/30/2021.
 */
@RestController
@RequestMapping("/customer")
public class CustomerResource implements IResourceController {

    private final CustomerService customerService;

    private final LoggerService loggerService;

    @Autowired
    public CustomerResource(CustomerService customerService, LoggerService loggerService){
        this.customerService = customerService;
        this.loggerService = loggerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        loggerService.putLogDatabase("Request call GET getAllCustomers", this, "CustomerService" );
        List<Customer> customers = customerService.findAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Customer>> getCustomersByCode(@RequestParam("customerCode") String code){
        loggerService.putLogDatabase(String.format("Request call GET getCustomersByCode code: %s", code), this, "CustomerService" );
        List<Customer> customers = customerService.findCustomersByCode(code);
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/find/code")
    public ResponseEntity<Customer> getCustomersByCustomerCode(@RequestParam("customerCode") String customerCode){
        loggerService.putLogDatabase(String.format("Request call GET getCustomersByCode customerCode: %s", customerCode), this, "CustomerService" );
        Customer customer = customerService.findUniqueCustomersByCode(customerCode);
        return ResponseEntity.ok(customer);
    }

}