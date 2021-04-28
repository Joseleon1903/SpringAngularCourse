package com.app.spring.angular.course.SpringAngularCourse.service;

import com.app.spring.angular.course.SpringAngularCourse.exception.UserNotFoundException;
import com.app.spring.angular.course.SpringAngularCourse.jparepository.RoleRepository;
import com.app.spring.angular.course.SpringAngularCourse.jparepository.UserRepository;
import com.app.spring.angular.course.SpringAngularCourse.model.Role;
import com.app.spring.angular.course.SpringAngularCourse.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by jose de leon on 4/28/2021.
 */
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;


    public UserService(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User searchUserByUsernameOrEmail(String username, String email){
        return userRepository.findByUsernameOrEmailAndStatus(username, email, "ACTIVE").orElseThrow( ()->new UserNotFoundException("user not found"));
    }

    public List<User> findAllUsers(){
        return userRepository.findByStatus("ACTIVE").get();
    }

    public User registerUser(User user){

        if(userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail()).isPresent()){
            throw new UserNotFoundException("user already register");
        }
        Role role = roleRepository.getOne(user.getRole().getId());
        user.setRole(role);
        return userRepository.save(user);
    }

    public User updateUser(User user){
        if(userRepository.findById(user.getId()).isPresent()){
            return userRepository.save(user);
        }
        throw new UserNotFoundException("user not found");
    }

}