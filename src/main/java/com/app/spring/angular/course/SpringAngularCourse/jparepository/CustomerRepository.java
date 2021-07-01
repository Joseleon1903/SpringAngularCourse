package com.app.spring.angular.course.SpringAngularCourse.jparepository;

import com.app.spring.angular.course.SpringAngularCourse.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Created by jose de leon on 4/30/2021.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c")
    Optional<List<Customer>> findAllCustomers();

    @Query("select c from Customer c where lower(c.customerCode) like lower(concat('%', ?1,'%'))")
    Optional<List<Customer>> findCustomersByCode(String code);

    Optional<Customer> findByCustomerCode(String customerCode);
}
