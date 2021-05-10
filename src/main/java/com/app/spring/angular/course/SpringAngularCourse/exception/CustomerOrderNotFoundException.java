package com.app.spring.angular.course.SpringAngularCourse.exception;

/**
 * Created by jose de leon on 5/10/2021.
 */
public class CustomerOrderNotFoundException extends RuntimeException{

    public static String defaultDescription = "Customer Order doesn't exist";

    public CustomerOrderNotFoundException(String messsage){
        super(messsage);
    }

    public CustomerOrderNotFoundException(){
        super(defaultDescription);
    }

}
