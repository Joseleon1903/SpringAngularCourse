package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.dto.AngularUserDto;
import com.app.spring.angular.course.SpringAngularCourse.dto.LoginDto;
import com.app.spring.angular.course.SpringAngularCourse.model.User;
import com.app.spring.angular.course.SpringAngularCourse.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jose de leon on 5/23/2021.
 */
@RestController
@RequestMapping("/login")
public class LoginResource {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserService userService;

    @Autowired
    public LoginResource(UserService userService){
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<AngularUserDto> loginUser(@RequestBody LoginDto loginDto){
        logger.info("Entering in loginUser");
        logger.info("Param: "+loginDto.getEmail());
        logger.info("Param: "+loginDto.getUsername());
        logger.info("Param: "+loginDto.getPassword());

        User user = userService.searchUserByUsernameOrEmail(loginDto.getUsername(), loginDto.getEmail());

        if(user.getPassword().equalsIgnoreCase(loginDto.getPassword())){
            AngularUserDto dto = new AngularUserDto();
            dto.setUserId(user.getId());
            dto.setUsername(user.getUsername());
            dto.setStatus(user.getStatus());
            dto.setRole(user.getRole().getRoleName());
            dto.setProfileUrl(user.getPictureUrl());
            return ResponseEntity.accepted().body(dto);

        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}