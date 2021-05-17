package com.app.spring.angular.course.SpringAngularCourse.jparepository;

import com.app.spring.angular.course.SpringAngularCourse.model.FullTimeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jose de leon on 5/17/2021.
 */
public interface FullTimeEmployeeRepository extends JpaRepository<FullTimeEmployee, Long> {
}
