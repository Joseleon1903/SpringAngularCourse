package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jose de leon on 4/28/2021.
 */
@Data
@Entity(name = "Role")
@Table(name = "Role",
        uniqueConstraints = {
                @UniqueConstraint(name = "role_name_unique", columnNames = "role_name")

        })
@Check(constraints = "permission IN ('BASIC', 'NONE', 'ADMIN')")
public class Role {

    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName ="role_sequence" ,
            allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "role_sequence")
    @Column(name = "role_id", nullable = false)
    private Long id;

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @Column(name = "permission", nullable = false)
    private String permissions;

    public Role(){}

    public Role(Long roleId){
        this.id = roleId;
    }

}
