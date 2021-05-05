package com.app.spring.angular.course.SpringAngularCourse.service;

import com.app.spring.angular.course.SpringAngularCourse.jparepository.CustomerRepository;
import com.app.spring.angular.course.SpringAngularCourse.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by jose de leon on 4/30/2021.
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAllCustomers().get();
    }

    public List<Customer> findCustomersByCode(String code) {
        return customerRepository.findCustomersByCode(code).get();
    }

}