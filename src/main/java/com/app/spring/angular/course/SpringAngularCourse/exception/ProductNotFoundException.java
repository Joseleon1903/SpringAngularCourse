package com.app.spring.angular.course.SpringAngularCourse.exception;

/**
 * Created by jose de leon on 5/10/2021.
 */
public class ProductNotFoundException extends RuntimeException{

    public static String defaultDescription = "Product not found in the database";

    public ProductNotFoundException(String messsage){
        super(messsage);
    }

    public ProductNotFoundException(){
        super(defaultDescription);
    }
}
