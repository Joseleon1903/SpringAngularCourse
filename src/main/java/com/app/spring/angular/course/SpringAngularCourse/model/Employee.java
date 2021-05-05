package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jose de leon on 4/19/2021.
 */
@Data
@Entity(name = "Employee")
@Table(name = "Employee")
public class Employee implements Serializable{


    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName ="employee_sequence" ,
            allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence")
    @Column(name = "employee_id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "job_title", nullable = false)
    private String jobTittle;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "employee_code" ,nullable = false, updatable = false)
    private String employeeCode;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTittle='" + jobTittle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }
}
