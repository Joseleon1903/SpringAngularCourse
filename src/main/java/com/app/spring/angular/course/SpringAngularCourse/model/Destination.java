package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;
import javax.persistence.*;

/**
 * Created by jose de leon on 4/27/2021.
 */
@Data
@Entity(name = "Destination")
@Table(name = "Destination",
        uniqueConstraints = {
                @UniqueConstraint(name = "destination_name_unique", columnNames = "name")
        })
public class Destination {

    @Id
    @SequenceGenerator(
            name = "destination_sequence",
            sequenceName ="destination_sequence" ,
            allocationSize =1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "postal_code", nullable = false, length = 5)
    private String postalCode;

    @Column(name = "charge", nullable = false)
    private Double charge = 0.0;

    public Destination(){}

}
