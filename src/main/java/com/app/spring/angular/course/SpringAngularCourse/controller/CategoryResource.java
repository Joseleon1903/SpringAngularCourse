package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.model.Category;
import com.app.spring.angular.course.SpringAngularCourse.model.Employee;
import com.app.spring.angular.course.SpringAngularCourse.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jose de leon on 4/27/2021.
 */
@RestController
@RequestMapping("/category")
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categorylist = categoryService.findAllCategory();
        return ResponseEntity.ok(categorylist);
    }

}
