package com.app.spring.angular.course.SpringAngularCourse.service;

import com.app.spring.angular.course.SpringAngularCourse.dto.ProductReview;
import com.app.spring.angular.course.SpringAngularCourse.exception.ProductNotFoundException;
import com.app.spring.angular.course.SpringAngularCourse.jparepository.ProductRepository;
import com.app.spring.angular.course.SpringAngularCourse.model.Product;
import com.app.spring.angular.course.SpringAngularCourse.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jose de leon on 4/29/2021.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> findByCategoryId(Long id){
        return productRepository.findByCategoryId(id).get();
    }

    public Product findByProductId(Long id){
        return productRepository.findById(id).get();
    }

    public Product updateProduct(Product product) {
        if(productRepository.findById(product.getId()).isPresent()){
            return productRepository.save(product);
        }
        throw new ProductNotFoundException();
    }

    public Product createProduct(Product product) {
        product.setId(0L);
        return productRepository.save(product);
    }

    @Transactional
    public Product addReviewProduct(ProductReview review) {
        Product prod =  productRepository.findById(review.getProductId()).orElseThrow( () -> new ProductNotFoundException());

        Review reviewEntity =  new Review();

        if(prod.getReview() != null){
            reviewEntity = prod.getReview();
            reviewEntity.setLikeCounter(review.getLikeCounter());
            reviewEntity.setDislikeCounter(review.getDislikeCounter());
            return prod;
        }
        reviewEntity.setLikeCounter(review.getLikeCounter());
        reviewEntity.setDislikeCounter(review.getDislikeCounter());
        prod.setReview(reviewEntity);
        return prod;
    }
}