package com.app.spring.angular.course.SpringAngularCourse.jdbcrepository;

import com.app.spring.angular.course.SpringAngularCourse.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jose de leon on 4/27/2021.
 */
@Repository
public class StudentJdbcDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentJdbcDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //select name * form Student
    public List<Student> findAllStudent(){
        List<Student> students = jdbcTemplate.query("select * from Student", BeanPropertyRowMapper.newInstance(Student.class));
        return students;
    }

}
