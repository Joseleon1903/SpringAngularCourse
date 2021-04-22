package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.model.Employee;
import com.app.spring.angular.course.SpringAngularCourse.model.Student;
import com.app.spring.angular.course.SpringAngularCourse.service.EmployeeService;
import com.app.spring.angular.course.SpringAngularCourse.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jose de leon on 4/22/2021.
 */
@RestController
@RequestMapping("/student")
public class StudentResources {

    private final StudentService studentService;

    public StudentResources(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> employees = studentService.findAllStudents();
        return ResponseEntity.ok(employees);
    }
}
