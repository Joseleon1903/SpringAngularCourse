package com.app.spring.angular.course.SpringAngularCourse.exception;

/**
 * Created by jose de leon on 5/10/2021.
 */
public class EmployeeNotFoundException extends RuntimeException{

    public static String defaultDescription = "Employee not found in the database";

    public EmployeeNotFoundException(String messsage){
        super(messsage);
    }

    public EmployeeNotFoundException(){
        super(defaultDescription);
    }

}
