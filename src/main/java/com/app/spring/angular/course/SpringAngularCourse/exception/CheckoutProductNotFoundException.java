package com.app.spring.angular.course.SpringAngularCourse.exception;

/**
 * Created by jose de leon on 5/10/2021.
 */
public class CheckoutProductNotFoundException extends RuntimeException{

    public static String defaultDescription = "Product to checkout doesn't exist.";

    public CheckoutProductNotFoundException(String messsage){
        super(messsage);
    }

    public CheckoutProductNotFoundException(){
        super(defaultDescription);
    }

}