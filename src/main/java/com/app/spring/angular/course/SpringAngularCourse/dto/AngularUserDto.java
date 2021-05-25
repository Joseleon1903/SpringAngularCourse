package com.app.spring.angular.course.SpringAngularCourse.dto;

import lombok.Data;

/**
 * Created by jose de leon on 5/24/2021.
 */
@Data
public class AngularUserDto {

    private Long userId;

    private String username;

    private String status;

    private String role;

    private String profileUrl;

}
