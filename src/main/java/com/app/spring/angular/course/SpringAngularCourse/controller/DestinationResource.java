package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.model.Destination;
import com.app.spring.angular.course.SpringAngularCourse.service.DestinationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<Destination> destinationList = destinationService.findAllDestination();
        return ResponseEntity.ok(destinationList);
    }

    @PostMapping
    public ResponseEntity<Destination> postCreateDestination(@RequestBody Destination destination){
        Destination destinationOut = destinationService.createDestination(destination);
        return ResponseEntity.status(HttpStatus.CREATED).body(destinationOut);
    }

    @GetMapping("/search")
    public ResponseEntity<Destination> getDestinationbByParam(@RequestParam("destinationId") Long destinationId){
        Destination destinationOut = destinationService.findDestinationById(destinationId);
        return ResponseEntity.ok(destinationOut);
    }

    @PutMapping
    public ResponseEntity<Destination> putDestination(@RequestBody Destination destination){
        Destination destinationOut = destinationService.updateDestination(destination);
        return ResponseEntity.ok(destinationOut);
    }

}