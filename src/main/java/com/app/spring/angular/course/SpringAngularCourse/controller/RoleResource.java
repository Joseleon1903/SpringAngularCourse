package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.model.Role;
import com.app.spring.angular.course.SpringAngularCourse.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jose de leon on 4/28/2021.
 */
@RestController
@RequestMapping("/role")
public class RoleResource {

    private final RoleService roleService;

    public RoleResource(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> roles = roleService.findAllRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/find")
    public ResponseEntity<Role> getRoleByName(@RequestParam("roleName") String roleName){
        Role role = roleService.findRoleByRoleName(roleName.toUpperCase());
        return ResponseEntity.ok(role);
    }
}
