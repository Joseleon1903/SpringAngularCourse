package com.app.spring.angular.course.SpringAngularCourse.utils;

import com.app.spring.angular.course.SpringAngularCourse.model.Product;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by jose de leon on 5/3/2021.
 */
public class ShoppingUtilities {

    public static BigDecimal Itbis_tax = new BigDecimal(0.30);

    private static DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public static BigDecimal getTotalProductPrice(List<Product> products){
        BigDecimal tot = BigDecimal.ZERO;
        for (Product p : products){
            BigDecimal price = p.getPrice();
            BigDecimal discont = p.getDiscountPercent().divide(new BigDecimal(100));
            BigDecimal finalPrice = price.subtract(discont.multiply(price));
            tot = tot.add(finalPrice);
        }
        return tot;
    }

    public static BigDecimal getTaxCharge(BigDecimal totalPrice){
        BigDecimal itbis = totalPrice.subtract(totalPrice.multiply(Itbis_tax)) ;
        return itbis;
    }

    public static BigDecimal getFinalPrice(BigDecimal totalPrice, BigDecimal taxCharge){
        BigDecimal outDouble = totalPrice.add(taxCharge);
        return outDouble;
    }
}
