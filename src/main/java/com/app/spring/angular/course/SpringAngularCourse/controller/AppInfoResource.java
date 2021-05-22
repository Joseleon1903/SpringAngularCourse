package com.app.spring.angular.course.SpringAngularCourse.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jose de leon on 5/22/2021.
 */
@RestController
@RequestMapping("/api")
public class AppInfoResource {


    @GetMapping
    public ResponseEntity<String> getApiInfo(){
        return ResponseEntity.ok("version:0.0.1");
    }

}
