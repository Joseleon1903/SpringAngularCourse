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

    //select * form Student
    public List<Student> findAllStudent(){
        List<Student> students = jdbcTemplate.query("select * from Student", BeanPropertyRowMapper.newInstance(Student.class));
        return students;
    }

    //select * from Student where id=?
    public Student findbyId(long id){
        Student students = jdbcTemplate.queryForObject("select * from Student where id=?",new StudentRowMapper(), id);
        return students;
    }

    public int deleteById(long id){
        return jdbcTemplate.update("delete from Student where id=?", id);
    }

    //insert into student
    public int insert(Student student){
        String query = "insert into Student (id, first_name, last_name, email, age ) VALUES (?, ?, ?,?, ?)";
        return jdbcTemplate.update(query, student.getId(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getAge());
    }

    public int upadate(Student student){
        String query = "update student set first_name = ?, set last_name = ?, set email =?, set age = ? where id = ? ";
        return jdbcTemplate.update(query, student.getFirstName(), student.getLastName(), student.getEmail(), student.getAge(), student.getId());
    }

}