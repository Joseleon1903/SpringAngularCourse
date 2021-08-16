package com.app.spring.angular.course.SpringAngularCourse.service;

import com.app.spring.angular.course.SpringAngularCourse.jparepository.MoonProductRepository;
import com.app.spring.angular.course.SpringAngularCourse.model.MoonProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jose de leon on 8/16/2021.
 */
@Service
public class MoonService {

    private final MoonProductRepository moonProductRepository;

    @Autowired
    public MoonService(MoonProductRepository moonProductRepository){
        this.moonProductRepository = moonProductRepository;
    }

    public MoonProduct addProduct(MoonProduct moonProduct) {
        return moonProductRepository.save(moonProduct);
    }
}
