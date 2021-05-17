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
public class FullTimeEmployee extends Employee{

    protected FullTimeEmployee(){
    }

    public FullTimeEmployee(String name, String email, String jobTittle, String phone, String imageUrl, String employeeCode, BigDecimal hourlyWage) {
        super(name,email,jobTittle,phone,imageUrl,employeeCode);
        this.salary = hourlyWage;
    }

    @Column(name = "salary")
    private BigDecimal salary;


    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "salary=" + salary +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTittle='" + jobTittle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", walletAmount=" + walletAmount +
                '}';
    }
}
