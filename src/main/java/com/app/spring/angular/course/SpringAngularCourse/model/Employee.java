package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by jose de leon on 4/19/2021.
 */
@Data
@Entity(name = "Employee")
@Table(name = "Employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "employee_type")
public abstract class Employee implements Serializable{


    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName ="employee_sequence" ,
            allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence")
    @Column(name = "employee_id", nullable = false)
    protected long id;

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "email", nullable = false)
    protected String email;

    @Column(name = "job_title", nullable = false)
    protected String jobTittle;

    @Column(name = "phone", nullable = false)
    protected String phone;

    @Column(name = "image_url", nullable = false)
    protected String imageUrl;

    @Column(name = "employee_code" ,nullable = false, updatable = false)
    protected String employeeCode;

    @Column(name = "wallet_amount", nullable = false)
    protected BigDecimal walletAmount;

    public Employee(String name, String email, String jobTittle, String phone, String imageUrl, String employeeCode) {
        this.name = name;
        this.email = email;
        this.jobTittle = jobTittle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
    }

    public Employee() {
    }

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
