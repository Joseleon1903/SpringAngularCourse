package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jose de leon on 5/22/2021.
         */
@RestController
@RequestMapping("/api")
public class AppInfoResource implements IResourceController {


    private final LoggerService loggerService;

    @Autowired
    public AppInfoResource(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @GetMapping
    public ResponseEntity<String> getApiInfo(){
        loggerService.putLogDatabase("get version request", this, null);
        return ResponseEntity.ok("version:0.0.3");
    }

}
