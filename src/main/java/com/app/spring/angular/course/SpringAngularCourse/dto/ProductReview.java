package com.app.spring.angular.course.SpringAngularCourse.dto;

import lombok.Data;

/**
 * Created by jose de leon on 5/11/2021.
 */
@Data
public class ProductReview {

    private Long productId;

    private String comment;

    private int likeCounter;

    private int dislikeCounter;

}
