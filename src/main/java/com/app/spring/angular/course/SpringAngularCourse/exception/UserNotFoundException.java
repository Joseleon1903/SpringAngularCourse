package com.app.spring.angular.course.SpringAngularCourse.exception;

/**
 * Created by jose de leon on 4/19/2021.
 */
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String messsage){
        super(messsage);
    }
}
