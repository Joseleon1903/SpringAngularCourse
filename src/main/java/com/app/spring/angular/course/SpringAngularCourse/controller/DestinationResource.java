package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.model.Destination;
import com.app.spring.angular.course.SpringAngularCourse.service.DestinationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jose de leon on 4/27/2021.
 */
@RestController
@RequestMapping("/destination")
public class DestinationResource {

    private final DestinationService destinationService;

    public DestinationResource(DestinationService destinationService){this.destinationService = destinationService;}

    @GetMapping
    public ResponseEntity<List<Destination>> getAllDestination(){
        List<Destination> destinationList = destinationService.findAllCategory();
        return ResponseEntity.ok(destinationList);
    }

}
