package com.app.spring.angular.course.SpringAngularCourse.jparepository;

import com.app.spring.angular.course.SpringAngularCourse.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jose de leon on 4/27/2021.
 */
public interface DestinationRepository extends JpaRepository<Destination, Long> {
}
