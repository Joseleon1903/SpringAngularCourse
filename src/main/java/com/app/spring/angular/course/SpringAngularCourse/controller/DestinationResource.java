package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.model.Destination;
import com.app.spring.angular.course.SpringAngularCourse.service.DestinationService;
import com.app.spring.angular.course.SpringAngularCourse.service.LoggerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jose de leon on 4/27/2021.
 */
@RestController
@RequestMapping("/destination")
public class DestinationResource implements IResourceController {

    private final DestinationService destinationService;

    private final LoggerService loggerService;

    public DestinationResource(DestinationService destinationService,  LoggerService loggerService){this.destinationService = destinationService;
    this.loggerService= loggerService;
    }

    @GetMapping
    public ResponseEntity<List<Destination>> getAllDestination(){
        loggerService.putLogDatabase("Request call GET getAllDestination", this, "DestinationService" );
        List<Destination> destinationList = destinationService.findAllDestination();
        return ResponseEntity.ok(destinationList);
    }

    @PostMapping
    public ResponseEntity<Destination> postCreateDestination(@RequestBody Destination destination){
        loggerService.putLogDatabase("Request call POST postCreateDestination", this, "DestinationService" );
        Destination destinationOut = destinationService.createDestination(destination);
        return ResponseEntity.status(HttpStatus.CREATED).body(destinationOut);
    }

    @GetMapping("/search")
    public ResponseEntity<Destination> getDestinationbByParam(@RequestParam("destinationId") Long destinationId){
        loggerService.putLogDatabase(String.format("Request call GET getDestinationbByParam param: destinationId: %s", destinationId),this, "DestinationService" );
        Destination destinationOut = destinationService.findDestinationById(destinationId);
        return ResponseEntity.ok(destinationOut);
    }

    @PutMapping
    public ResponseEntity<Destination> putDestination(@RequestBody Destination destination){
        loggerService.putLogDatabase(String.format("Request call PUT putDestination "),this, "DestinationService" );
        Destination destinationOut = destinationService.updateDestination(destination);
        return ResponseEntity.ok(destinationOut);
    }

}