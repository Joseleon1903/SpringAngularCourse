package com.app.spring.angular.course.SpringAngularCourse.exception;

/**
 * Created by jose de leon on 5/17/2021.
 */
public class TransactionFailException extends RuntimeException{

    public static String defaultDescription = "transaction fail";

    public TransactionFailException(String messsage){
        super(messsage);
    }

    public TransactionFailException(){
        super(defaultDescription);
    }
}
