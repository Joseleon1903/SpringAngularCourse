package com.app.spring.angular.course.SpringAngularCourse.service;

import com.app.spring.angular.course.SpringAngularCourse.jdbcrepository.StudentJdbcDao;
import com.app.spring.angular.course.SpringAngularCourse.model.Student;
import com.app.spring.angular.course.SpringAngularCourse.jparepository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jose de leon on 4/22/2021.
 */
@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentJdbcDao studentJdbcDao;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentJdbcDao studentJdbcDao){
        this.studentRepository= studentRepository;
        this.studentJdbcDao = studentJdbcDao;
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public List<Student> findAllJdbcStudents(){
        return studentJdbcDao.findAllStudent();
    }



}
