package com.app.spring.angular.course.SpringAngularCourse.service;

import com.app.spring.angular.course.SpringAngularCourse.exception.DestinationNotFoundException;
import com.app.spring.angular.course.SpringAngularCourse.model.Destination;
import com.app.spring.angular.course.SpringAngularCourse.jparepository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by jose de leon on 4/27/2021.
 */
@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository){
        this.destinationRepository= destinationRepository;
    }

    public List<Destination> findAllDestination(){
        return destinationRepository.findAll();
    }

    public Destination createDestination(Destination destination) {
        destination.setId(0L);
        return destinationRepository.save(destination);
    }

    public Destination findDestinationById(Long destinationId) {
        return destinationRepository.findById(destinationId).get();
    }

    public Destination updateDestination(Destination destination) {
        if(destinationRepository.existsById(destination.getId())){
           return destinationRepository.save(destination);
        }
        throw new DestinationNotFoundException();
    }
}
