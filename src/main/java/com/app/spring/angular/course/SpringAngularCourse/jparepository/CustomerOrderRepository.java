package com.app.spring.angular.course.SpringAngularCourse.jparepository;

import com.app.spring.angular.course.SpringAngularCourse.model.CustomerOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by jose de leon on 5/3/2021.
 */
public interface CustomerOrderRepository  extends CrudRepository<CustomerOrder, Long>{

    Optional<CustomerOrder> findByOrderCode(String code);

}
