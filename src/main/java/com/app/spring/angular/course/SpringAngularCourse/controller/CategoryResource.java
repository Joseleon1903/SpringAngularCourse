package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.model.Category;
import com.app.spring.angular.course.SpringAngularCourse.service.CategoryService;
import com.app.spring.angular.course.SpringAngularCourse.service.LoggerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jose de leon on 4/27/2021.
 */
@RestController
@RequestMapping("/category")
public class CategoryResource implements IResourceController {

    private final CategoryService categoryService;

    private final LoggerService loggerService;

    public CategoryResource(CategoryService categoryService, LoggerService loggerService){
        this.categoryService = categoryService;
        this.loggerService = loggerService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(@RequestParam("appName") String appName){
        loggerService.putLogDatabase(String.format("Request call GET getAllCategory param {appName : %s }", appName), this, "CategoryService" );
        List<Category> categorylist = categoryService.findAllCategory(appName);
        return ResponseEntity.ok(categorylist);
    }

}