package com.app.spring.angular.course.SpringAngularCourse.service;

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

    public List<Destination> findAllCategory(){
        return destinationRepository.findAll();
    }
}
