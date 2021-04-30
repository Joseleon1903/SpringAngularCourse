package com.app.spring.angular.course.SpringAngularCourse.user;

import com.app.spring.angular.course.SpringAngularCourse.model.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Created by jose de leon on 4/30/2021.
 */
@Data
public class UserJson {

    private Long id = 0L;
    private String email;
    private String username;
    private String password;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date creationDay = new Date();
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate = new Date();
    private String status;
    private Role role;
    private CustomerJson customer;


}
