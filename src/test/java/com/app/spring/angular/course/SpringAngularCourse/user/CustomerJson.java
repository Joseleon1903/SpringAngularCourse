package com.app.spring.angular.course.SpringAngularCourse.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Created by jose de leon on 4/30/2021.
 */
@Data
public class CustomerJson {

    private Long id = 0L;
    private String customerCode;
    private String firstName;
    private String lastName;
    private String address;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    private Long userId;
}
