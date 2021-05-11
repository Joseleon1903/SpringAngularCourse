package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;

import javax.persistence.*;


/**
 * Created by jose de leon on 5/11/2021.
 */
@Data
@Entity(name = "Review")
@Table(name =  "Review")
public class Review {

    @Id
    @SequenceGenerator(
            name = "review_sequence",
            sequenceName ="review_sequence" ,
            allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "review_sequence")
    @Column(name = "review_id" , updatable = false)
    private Long id;

    @Column(name = "like_counter")
    private int likeCounter;

    @Column(name = "dislike_counter")
    private int dislikeCounter;

    @OneToOne(mappedBy = "review", fetch = FetchType.LAZY)
    private Product product;


//    private List<String> comment;
//
//    private LocalDateTime creation_date;

}
