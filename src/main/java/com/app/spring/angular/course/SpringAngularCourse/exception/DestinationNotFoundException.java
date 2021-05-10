package com.app.spring.angular.course.SpringAngularCourse.exception;

/**
 * Created by jose de leon on 5/10/2021.
 */
public class DestinationNotFoundException extends RuntimeException{

    public static String defaultDescription = "Destination not found in the database";

    public DestinationNotFoundException(String messsage){
        super(messsage);
    }

    public DestinationNotFoundException(){
        super(defaultDescription);
    }

}
