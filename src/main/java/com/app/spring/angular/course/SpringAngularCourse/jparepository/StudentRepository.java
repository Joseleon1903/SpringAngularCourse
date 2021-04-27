package com.app.spring.angular.course.SpringAngularCourse.jparepository;

import com.app.spring.angular.course.SpringAngularCourse.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jose de leon on 4/22/2021.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {


}
