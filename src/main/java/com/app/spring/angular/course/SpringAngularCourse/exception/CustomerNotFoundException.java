package com.app.spring.angular.course.SpringAngularCourse.exception;

/**
 * Created by jose de leon on 5/10/2021.
 */
public class CustomerNotFoundException extends RuntimeException{

    public static String defaultDescription = "Customer not found in the database";

    public CustomerNotFoundException(String messsage){
        super(messsage);
    }

    public CustomerNotFoundException(){
        super(defaultDescription);
    }
}
