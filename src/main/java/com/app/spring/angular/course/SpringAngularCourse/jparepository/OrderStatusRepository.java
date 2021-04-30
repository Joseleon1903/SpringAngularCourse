package com.app.spring.angular.course.SpringAngularCourse.jparepository;

import com.app.spring.angular.course.SpringAngularCourse.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jose de leon on 4/30/2021.
 */
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long>{
}
