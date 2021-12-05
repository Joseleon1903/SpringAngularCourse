package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.model.Employee;
import com.app.spring.angular.course.SpringAngularCourse.model.MoonProduct;
import com.app.spring.angular.course.SpringAngularCourse.service.LoggerService;
import com.app.spring.angular.course.SpringAngularCourse.service.MoonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by jose de leon on 8/16/2021.
 */
@RestController
@RequestMapping("/moon")
public class MoonResources implements IResourceController{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final LoggerService loggerService;
    private final MoonService moonService;

    @Autowired
    public MoonResources(LoggerService loggerService,MoonService moonService ){
        this.loggerService= loggerService;
        this.moonService= moonService;
    }

    @PostMapping("/add/product")
    public ResponseEntity<Employee> addMoonProduct(@RequestBody MoonProduct moonProduct){
        loggerService.putLogDatabase(String.format("Request call POST addMoonProduct"),this, "MoonService" );
        MoonProduct productoMOut = moonService.addProduct(moonProduct);
        return new ResponseEntity(productoMOut, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<MoonProduct>> getAllMoonProduct(){
        loggerService.putLogDatabase(String.format("Request call GET getAllMoonProduct"),this, "MoonService" );
        List<MoonProduct> productoMOut = moonService.getAllProduct();
        return new ResponseEntity(productoMOut, HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<MoonProduct> getMoonProductFindId(@PathVariable("id") String id){
        loggerService.putLogDatabase(String.format("Request call GET getMoonProductFindId"),this, "MoonService" );
        System.out.println("PathParam id "+ id);
        long pId = Long.parseLong(id);
        MoonProduct productoMOut = moonService.getProductFindById(pId);
        return new ResponseEntity(productoMOut, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteMoonProductFindId(@PathVariable("id") String id){
        loggerService.putLogDatabase(String.format("Request call GET getMoonProductFindId"),this, "MoonService" );
        System.out.println("PathParam id "+ id);
        long pId = Long.parseLong(id);
        moonService.deleteProductFindById(pId);
        return ResponseEntity.accepted().build();
    }
}