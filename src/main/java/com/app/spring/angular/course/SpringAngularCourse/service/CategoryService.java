package com.app.spring.angular.course.SpringAngularCourse.service;

import com.app.spring.angular.course.SpringAngularCourse.model.Category;
import com.app.spring.angular.course.SpringAngularCourse.jparepository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jose de leon on 4/27/2021.
 */
@Service
public class CategoryService {

    public static String SERVICE_NAME = "CategoryService";

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository= categoryRepository;
    }

    public List<Category> findAllCategory(String appName){
        return categoryRepository.findByAppNameAndIsActiveTrue(appName).get();
    }
}
