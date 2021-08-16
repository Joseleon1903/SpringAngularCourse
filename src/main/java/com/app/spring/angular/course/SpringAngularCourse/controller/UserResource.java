package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.model.User;
import com.app.spring.angular.course.SpringAngularCourse.service.LoggerService;
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
public class UserResource implements IResourceController {

    private final UserService userService;

    private final LoggerService loggerService;

    public UserResource(UserService userService,  LoggerService loggerService){
        this.userService = userService;
        this.loggerService = loggerService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllActiveUsers(){
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/find")
    public ResponseEntity<User> getUsersByParamas(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "email", required = false)String email){
        loggerService.putLogDatabase(String.format("Request call GET getUsersByParamas" ),this, "UserService" );
        User user = userService.searchUserByUsernameOrEmail(username, email);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/create")
    public ResponseEntity<User> postCreateUser(@RequestBody User user){
        loggerService.putLogDatabase(String.format("Request call POST postCreateUser" ),this, "UserService" );
        User userOut = userService.registerUser(user);
        return new ResponseEntity(userOut, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> putUpdateUser(@RequestBody User user){
        loggerService.putLogDatabase(String.format("Request call PUT putUpdateUser" ),this, "UserService" );
        User userOut = userService.updateUser(user);
        return new ResponseEntity(userOut, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable(value = "userId") Long userId){
        loggerService.putLogDatabase(String.format("Request call DELETE deleteUserById param userId : %d", userId ),this, "UserService" );
        userService.deleteUserById(userId);
        return ResponseEntity.ok().build();
    }
}