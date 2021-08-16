package com.app.spring.angular.course.SpringAngularCourse.controller;

/**
 * Created by jose de leon on 8/16/2021.
 */
public interface IResourceController {

    default String getName(){
       return this.getClass().getSimpleName();
    }

}