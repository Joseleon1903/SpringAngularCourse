package com.app.spring.angular.course.SpringAngularCourse.service;

import com.app.spring.angular.course.SpringAngularCourse.jparepository.RoleRepository;
import com.app.spring.angular.course.SpringAngularCourse.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by jose de leon on 4/28/2021.
 */
@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository){
        this.roleRepository= roleRepository;
    }

    public List<Role> findAllRoles(){
       return roleRepository.findAll();
    }

    public Role findRoleByRoleName(String name){
        if(roleRepository.findByRoleName(name).isPresent()){
            return roleRepository.findByRoleName(name).get();
        }
        return null;
    }
}
