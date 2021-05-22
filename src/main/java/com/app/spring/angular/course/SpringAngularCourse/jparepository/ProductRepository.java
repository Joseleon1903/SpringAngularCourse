package com.app.spring.angular.course.SpringAngularCourse.jparepository;

import com.app.spring.angular.course.SpringAngularCourse.model.Product;
import org.springframework.data.domain.PageRequest;
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

    @Query("select p from Product p where ?1 is null or (lower(p.name) like lower(concat('%', ?1,'%')) or lower(p.description) like lower(concat('%', ?1,'%')))")
    List<Product> findByProductName(String name, PageRequest pages);
}
