package com.app.spring.angular.course.SpringAngularCourse.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @Column(name = "user_id", nullable = false)
    private Long id = 0L;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "picture_url", nullable = false)
    private String pictureUrl;

    @Embedded
    private UserPreference userPreference;

    @Column(name = "password", nullable = false)
    private String password;

    @CreationTimestamp
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "creation_day", nullable = false)
    private LocalDateTime creationDay;

    @CreationTimestamp
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id", nullable=false)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;

    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", creationDay=" + creationDay +
                ", lastUpdate=" + lastUpdate +
                ", status='" + status + '\'' +
                ", role=" + role.getId()+
                ", customer=" + customer != null ? customer.getId()+"" : "null" +
                '}';
    }
}