package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;
import javax.persistence.*;

/**
 * Created by jose de leon on 4/22/2021.
 */
@Data
@Entity(name = "Student")
@Table(name = "Student",
uniqueConstraints = {
        @UniqueConstraint(name = "student_email_unique", columnNames = "email")
}
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName ="student_sequence" ,
            allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "student_sequence")
    @Column(name = "id" , updatable = false)
    private Long id;

    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "age", nullable = false)
    private Integer age;

    public Student(Long id){
        this.id= id;
    }

    public Student(){}

}
