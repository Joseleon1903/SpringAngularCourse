package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by jose de leon on 5/13/2021.
 */
@Data
@Entity
public class PartTimeEmployee extends Employee{

    protected PartTimeEmployee(){
    }

    public PartTimeEmployee(String name, String email, String jobTittle, String phone, String imageUrl, String employeeCode, BigDecimal hourlyWage) {
        super(name,email,jobTittle,phone,imageUrl,employeeCode);
        this.hourlyWage = hourlyWage;
    }

    @Column(name = "hourly_wave")
    private BigDecimal hourlyWage;
}
