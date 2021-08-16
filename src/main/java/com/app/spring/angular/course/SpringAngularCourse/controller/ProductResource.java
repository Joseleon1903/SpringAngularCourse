package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.dto.IProductDetailRaw;
import com.app.spring.angular.course.SpringAngularCourse.dto.ProductReview;
import com.app.spring.angular.course.SpringAngularCourse.model.Product;
import com.app.spring.angular.course.SpringAngularCourse.model.TransactionHistory;
import com.app.spring.angular.course.SpringAngularCourse.service.LoggerService;
import com.app.spring.angular.course.SpringAngularCourse.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jose de leon on 4/29/2021.
 */
@RestController
@RequestMapping("/product")
public class ProductResource implements IResourceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final LoggerService loggerService;

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService, LoggerService loggerService){
        this.productService = productService;
        this.loggerService = loggerService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        loggerService.putLogDatabase(String.format("Request call GET getProducts"),this, "ProductService" );
        List<Product> products = productService.findAllProducts();
        return ResponseEntity.ok( products);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable(value = "categoryId") Long categoryId){
        loggerService.putLogDatabase(String.format("Request call GET getProductsByCategory param categoryId: %d", categoryId),this, "ProductService" );
        List<Product> products = productService.findByCategoryId(categoryId);
        return ResponseEntity.ok( products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductsByProductId(@PathVariable(value = "productId") Long productId){
        loggerService.putLogDatabase(String.format("Request call GET getProductsByProductId param productId: %d", productId),this, "ProductService" );
        Product product = productService.findById(productId);
        return ResponseEntity.ok(product);
    }

    @PutMapping
    public ResponseEntity<Product> putProductUpdate(@RequestBody Product product){
        loggerService.putLogDatabase(String.format("Request call PUT putProductUpdate"),this, "ProductService" );
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
        loggerService.putLogDatabase(String.format("Request call POST postProduct"),this, "ProductService" );
        Product productOut = productService.createProduct(product);
        return new ResponseEntity(productOut, HttpStatus.CREATED);
    }

    @PutMapping("/review")
    public ResponseEntity<Product> putProductReview(@RequestBody ProductReview review){
        loggerService.putLogDatabase(String.format("Request call PUT putProductReview"),this, "ProductService" );
        Product productOut = productService.addReviewProduct(review);
        return new ResponseEntity(productOut, HttpStatus.CREATED);
    }

    @GetMapping("/paginated")
    public ResponseEntity<List<Product>> getPaginatedProducts(@RequestParam("page") int page,
                                                                             @RequestParam("size") int size,
                                                                             @RequestParam(value = "name", required = false) String name){
        PageRequest pages = PageRequest.of(page, size, Sort.by("id").ascending());
        if(name == null){
            name= "";
        }
        loggerService.putLogDatabase(String.format("Request call GET getPaginatedProducts param page: %d , size: %d , filter: %s", page,size, name),this, "ProductService" );
        List<Product> response = productService.getPaginatedByName(name, pages);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/paginated/filter")
    public ResponseEntity<List<Product>> getPaginatedFilteredProducts(@RequestParam("page") int page,
                                                              @RequestParam("size") int size,
                                                              @RequestParam(value = "categoryId", required = false)  String categoryId,
                                                              @RequestParam(value = "minPrice", required = false)  String minPrice,
                                                              @RequestParam(value = "maxPrice", required = false)  String maxPrice,
                                                              @RequestParam(value = "keyword", required = false) String keyWord){
        PageRequest pages = PageRequest.of(page, size, Sort.by("id").ascending());
        loggerService.putLogDatabase(String.format("Request call GET getPaginatedFilteredProducts param page: %d , size: %d , filter: %s , minPrice: %s, maxPrice: %s ", page,size, keyWord, minPrice, maxPrice),this, "ProductService" );
        List<Product> response = productService.getPaginatedFiltered(categoryId,minPrice,maxPrice, keyWord, pages);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/details")
    public ResponseEntity<List<IProductDetailRaw>> getProductsDetails(){
        loggerService.putLogDatabase(String.format("Request call GET getProductsDetails"),this, "ProductService" );
        List<IProductDetailRaw> response = productService.getProductsDetail();
        return ResponseEntity.ok(response);
    }


}