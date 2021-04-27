package com.app.spring.angular.course.SpringAngularCourse.model;

import java.util.Date;

/**
 * Created by jose de leon on 4/27/2021.
 */
public class User {

    private Long id;

    private String email;

    private String username;

    private String password;

    private Date creationDay;

    private Date lastUpadate;

    private String status;

    private Customer customer;

    private User(){}

}