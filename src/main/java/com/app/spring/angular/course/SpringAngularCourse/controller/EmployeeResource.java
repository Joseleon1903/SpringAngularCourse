package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.model.Employee;
import com.app.spring.angular.course.SpringAngularCourse.model.FullTimeEmployee;
import com.app.spring.angular.course.SpringAngularCourse.model.PartTimeEmployee;
import com.app.spring.angular.course.SpringAngularCourse.service.EmployeeService;
import com.app.spring.angular.course.SpringAngularCourse.service.LoggerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by jose de leon on 4/19/2021.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeResource implements IResourceController {

    private final EmployeeService employeeService;

    private final LoggerService loggerService;


    public EmployeeResource(EmployeeService employeeService, LoggerService loggerService){
        this.employeeService = employeeService;
        this.loggerService = loggerService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        loggerService.putLogDatabase(String.format("Request call GET getAllEmployees"),this, "EmployeeService" );
        List<Employee> employees = employeeService.findAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        loggerService.putLogDatabase(String.format("Request call GET getEmployeeById param id: %s", id),this, "EmployeeService" );
        Employee employee = employeeService.findEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/find/code/{code}")
    public ResponseEntity<Employee> getEmployeeByCode(@PathVariable("code") String code){
        loggerService.putLogDatabase(String.format("Request call GET getEmployeeByCode param code: %s", code),this, "EmployeeService" );
        Employee employee = employeeService.findEmployeeByCode(code);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/full/time/add")
    public ResponseEntity<Employee> addFullTimeEmployee(@RequestBody FullTimeEmployee fullTimeEmployee){
        loggerService.putLogDatabase(String.format("Request call POST addFullTimeEmployee"),this, "EmployeeService" );
        Employee employeeOut = employeeService.addEmployee(fullTimeEmployee);
        return new ResponseEntity(employeeOut, HttpStatus.CREATED);
    }

    @PostMapping("/part/time/add")
    public ResponseEntity<Employee> addPartTimeEmployee(@RequestBody PartTimeEmployee partTimeEmployee){
        loggerService.putLogDatabase(String.format("Request call POST addPartTimeEmployee"),this, "EmployeeService" );
        Employee employeeOut = employeeService.addEmployee(partTimeEmployee);
        return new ResponseEntity(employeeOut, HttpStatus.CREATED);
    }

    @PutMapping("/part/time/update")
    public ResponseEntity<Employee> updatePartTimeEmployee(@RequestBody PartTimeEmployee partTimeEmployee){
        loggerService.putLogDatabase(String.format("Request call PUT updatePartTimeEmployee"),this, "EmployeeService" );
        Employee employeeOut = employeeService.updateEmployee(partTimeEmployee);
        return new ResponseEntity(employeeOut, HttpStatus.CREATED);
    }

    @PutMapping("/full/time/update")
    public ResponseEntity<Employee> updateFullTimeEmployee(@RequestBody FullTimeEmployee fullTimeEmployee){
        loggerService.putLogDatabase(String.format("Request call PUT updateFullTimeEmployee"),this, "EmployeeService" );
        Employee employeeOut = employeeService.updateEmployee(fullTimeEmployee);
        return new ResponseEntity(employeeOut, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id")  Long id){
        loggerService.putLogDatabase(String.format("Request call DELETE deleteEmployee"),this, "EmployeeService" );
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

}