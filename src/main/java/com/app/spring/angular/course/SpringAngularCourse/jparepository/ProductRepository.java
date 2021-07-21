package com.app.spring.angular.course.SpringAngularCourse.jparepository;

import com.app.spring.angular.course.SpringAngularCourse.dto.IProductDetailRaw;
import com.app.spring.angular.course.SpringAngularCourse.model.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
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

    @Query("select p from Product p where " +
            "(:categoryId is null or p.category.id = :categoryId) " +
            "and (:minPriceNumber is null or p.price >= :minPriceNumber) " +
            "and (:maxPriceNumber is null or p.price <= :maxPriceNumber )" +
            "and ((:keyWord is null or lower(p.name) like lower(concat('%', :keyWord,'%')))" +
            "or (:keyWord is null or lower(p.description) like lower(concat('%', :keyWord,'%'))))" )
    List<Product> findByProductWithFilter(@Param("categoryId") Long categoryId,
                                          @Param("minPriceNumber") BigDecimal minPriceNumber,
                                          @Param("maxPriceNumber") BigDecimal maxPriceNumber,
                                          @Param("keyWord") String keyWord, Pageable pages);

    /**
     * IProductDetailRaw is a proyection of returned columns.
     * @return List<IProductDetailRaw>
     */
    @Query(value = "select prod.id as productId , prod.productCode as productCode,  prod.name as name ," +
            "prod.description as description , prod.discountPercent as discountPercent , prod.price as price, prod.category.id as categoryId,  prod.category.code as categoryCode " +
            "FROM Product prod")
    List<IProductDetailRaw> findProductDetail();

}
