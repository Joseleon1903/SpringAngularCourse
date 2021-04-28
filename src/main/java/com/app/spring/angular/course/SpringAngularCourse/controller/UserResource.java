package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.model.User;
import com.app.spring.angular.course.SpringAngularCourse.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by jose de leon on 4/28/2021.
 */
@RestController
@RequestMapping("/user")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllActiveUsers(){
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/find")
    public ResponseEntity<User> getUsersByParamas(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "email", required = false)String email){
        User user = userService.searchUserByUsernameOrEmail(username, email);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/create")
    public ResponseEntity<User> postCreateUser(@RequestBody User user){
        User userOut = userService.registerUser(user);
        return new ResponseEntity(userOut, HttpStatus.CREATED);
    }

}