package com.app.spring.angular.course.SpringAngularCourse.dto;


import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

/**
 * Created by jose de leon on 7/4/2021.
 */
public interface IProductDetailRaw {

//    @Value("#{target.productId}")
    Long getProductId();

    String getProductCode();

    String getName();

    String getDescription();

    BigDecimal getDiscountPercent();

    BigDecimal getPrice();

    Long getCategoryId();

    String getCategoryCode();
}
