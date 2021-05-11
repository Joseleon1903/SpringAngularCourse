package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.dto.ProductReview;
import com.app.spring.angular.course.SpringAngularCourse.model.Product;
import com.app.spring.angular.course.SpringAngularCourse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jose de leon on 4/29/2021.
 */
@RestController
@RequestMapping("/product")
public class ProductResource {

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = productService.findAllProducts();
        return ResponseEntity.ok( products);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable(value = "categoryId") Long categoryId){
        List<Product> products = productService.findByCategoryId(categoryId);
        return ResponseEntity.ok( products);
    }

    @PutMapping
    public ResponseEntity<Product> putProductUpdate(@RequestBody Product product){
        Product productOut = productService.updateProduct(product);
        return ResponseEntity.ok(productOut);
    }

    @GetMapping("/search")
    public ResponseEntity<Product> getProductByParam(@RequestParam("productId") Long productId){
        Product product = productService.findByProductId(productId);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> postProduct(@RequestBody Product product){
        Product productOut = productService.createProduct(product);
        return new ResponseEntity(productOut, HttpStatus.CREATED);
    }

    @PutMapping("/review")
    public ResponseEntity<Product> postProduct(@RequestBody ProductReview review){
        Product productOut = productService.addReviewProduct(review);
        return new ResponseEntity(productOut, HttpStatus.CREATED);
    }



}