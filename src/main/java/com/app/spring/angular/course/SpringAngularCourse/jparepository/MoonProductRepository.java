package com.app.spring.angular.course.SpringAngularCourse.jparepository;

import com.app.spring.angular.course.SpringAngularCourse.model.MoonProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jose de leon on 8/16/2021.
 */
public interface MoonProductRepository extends JpaRepository<MoonProduct, Long> {
}
