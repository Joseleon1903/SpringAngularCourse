package com.app.spring.angular.course.SpringAngularCourse.jparepository;

import com.app.spring.angular.course.SpringAngularCourse.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * Created by jose de leon on 4/27/2021.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<List<Category>> findByIsActiveTrue();

}
