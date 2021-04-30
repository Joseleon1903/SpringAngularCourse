package com.app.spring.angular.course.SpringAngularCourse.jparepository;

import com.app.spring.angular.course.SpringAngularCourse.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

/**
 * Created by jose de leon on 4/29/2021.
 */
public interface ProductRepository extends JpaRepository<Product, Long>{

    @Query("select p from Product p where p.category.id = ?1" )
    Optional<List<Product>> findByCategoryId(Long categoryId);

}
