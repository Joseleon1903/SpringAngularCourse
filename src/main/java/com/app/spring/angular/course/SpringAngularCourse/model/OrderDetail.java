package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jose de leon on 4/27/2021.
 */
@Data
@Entity(name = "Order_detail")
@Table(name = "Order_detail")
public class OrderDetail {

    @Id
    @SequenceGenerator(
            name = "order_detail_sequence",
            sequenceName ="order_detail_sequence" ,
            allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "order_detail_sequence")
    @Column(name = "order_detail_id", nullable = false)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Order_Detail_Product",
            joinColumns = { @JoinColumn(name = "order_detail_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
   private Set<Product> products = new HashSet<>();

    @Column(name = "product_total_price", nullable = false)
    private BigDecimal productTotalPrice;

    @Column(name = "tax_charge", nullable = false)
    private BigDecimal taxCharge;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", products Size=" + products.size() +
                ", productTotalPrice=" + productTotalPrice +
                ", taxCharge=" + taxCharge +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
