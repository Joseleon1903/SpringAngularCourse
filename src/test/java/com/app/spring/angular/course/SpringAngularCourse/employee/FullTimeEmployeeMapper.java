package com.app.spring.angular.course.SpringAngularCourse.employee;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by jose de leon on 5/18/2021.
 */
@Data
public class FullTimeEmployeeMapper {


    protected long id;

    protected String name;

    protected String email;

    protected String jobTittle;

    protected String phone;

    protected String imageUrl;

    protected String employeeCode;

    protected BigDecimal walletAmount;

    private BigDecimal salary;

}
