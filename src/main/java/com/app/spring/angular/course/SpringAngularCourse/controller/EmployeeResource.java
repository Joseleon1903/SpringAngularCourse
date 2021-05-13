package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.model.Employee;
import com.app.spring.angular.course.SpringAngularCourse.model.FullTimeEmployee;
import com.app.spring.angular.course.SpringAngularCourse.model.PartTimeEmployee;
import com.app.spring.angular.course.SpringAngularCourse.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by jose de leon on 4/19/2021.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/full/time/add")
    public ResponseEntity<Employee> addFullTimeEmployee(@RequestBody FullTimeEmployee fullTimeEmployee){
        Employee employeeOut = employeeService.addEmployee(fullTimeEmployee);
        return new ResponseEntity(employeeOut, HttpStatus.CREATED);
    }

    @PostMapping("/part/time/add")
    public ResponseEntity<Employee> addPartTimeEmployee(@RequestBody PartTimeEmployee partTimeEmployee){
        Employee employeeOut = employeeService.addEmployee(partTimeEmployee);
        return new ResponseEntity(employeeOut, HttpStatus.CREATED);
    }

    @PutMapping("/part/time/update")
    public ResponseEntity<Employee> updatePartTimeEmployee(@RequestBody PartTimeEmployee partTimeEmployee){
        Employee employeeOut = employeeService.updateEmployee(partTimeEmployee);
        return new ResponseEntity(employeeOut, HttpStatus.CREATED);
    }

    @PutMapping("/full/time/update")
    public ResponseEntity<Employee> updateFullTimeEmployee(@RequestBody FullTimeEmployee fullTimeEmployee){
        Employee employeeOut = employeeService.updateEmployee(fullTimeEmployee);
        return new ResponseEntity(employeeOut, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id")  Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

}
