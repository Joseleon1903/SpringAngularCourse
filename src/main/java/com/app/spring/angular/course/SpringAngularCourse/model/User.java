package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;
import org.hibernate.annotations.Check;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by jose de leon on 4/27/2021.
 */
@Data
@Entity(name = "User")
@Table(name = "Sys_User",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_username_unique", columnNames = "username"),
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        })
@Check(constraints = "status IN ('ACTIVE', 'PENDING', 'INACTIVE', 'BLOCKED')")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName ="user_sequence" ,
            allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_sequence")
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "creation_day", nullable = false)
    private Date creationDay = new Date();

    @Column(name = "last_update", nullable = false)
    private Date lastUpdate = new Date();

    @Column(name = "status", nullable = false)
    private String status;

    @OneToOne
    private Role role;
//
//    @OneToOne
//    private Customer customer;

    private User(){}

}