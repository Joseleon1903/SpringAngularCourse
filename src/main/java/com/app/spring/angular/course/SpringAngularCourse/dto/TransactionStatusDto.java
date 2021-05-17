package com.app.spring.angular.course.SpringAngularCourse.dto;

import lombok.Data;

/**
 * Created by jose de leon on 5/17/2021.
 */
@Data
public class TransactionStatusDto {


    public static String SUCCESS = "transaction completed successfully";

    private String transactionId;

    private String result;


}
