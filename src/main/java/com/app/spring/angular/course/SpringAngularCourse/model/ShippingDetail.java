package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by jose de leon on 4/27/2021.
 */
@Data
@Entity(name = "ShippingDetail")
@Table(name = "Shipping_Detail",
        uniqueConstraints = {
                @UniqueConstraint(name = "shipping_detail_code_unique", columnNames = "code")
        })
public class ShippingDetail {

    @Id
    @SequenceGenerator(
            name = "shipping_detail_sequence",
            sequenceName ="shipping_detail_sequence" ,
            allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "shipping_detail_sequence")
    private Long id;

    @Column(name ="code", nullable = false)
    private String code;

    @Column(name ="destination_address", nullable = false)
    private String destinationAddress;

    @Column(name ="delivery_date", nullable = false)
    private Date deliveryDate;

    @OneToOne
    private Destination destination;

    @Column(name ="shipping_charge", nullable = false)
    private Double shippingCharge;

}
