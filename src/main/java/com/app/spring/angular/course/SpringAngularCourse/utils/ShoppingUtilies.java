package com.app.spring.angular.course.SpringAngularCourse.utils;

import com.app.spring.angular.course.SpringAngularCourse.model.Product;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by jose de leon on 5/3/2021.
 */
public class ShoppingUtilies {

    public static Double Itbis_tax = 0.30;

    private static DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public static Double getTotalProductPrice(List<Product> products){
        Double tot = 0D;
        for (Product p : products){
            Double price = p.getPrice();
            Double discont = p.getDiscountPercent() /100;
            Double finalPrice = price - (discont * price);
            tot += finalPrice;
        }
        return Double.parseDouble(decimalFormat.format(tot));
    }

    public static Double getTaxCharge(Double totalPrice){
        Double itbis = totalPrice -  (totalPrice * Itbis_tax);
        return Double.parseDouble(decimalFormat.format(itbis));
    }

    public static Double getFinalPrice(Double totalPrice, Double taxCharge){
        Double outDouble = totalPrice + taxCharge;
        return Double.parseDouble(decimalFormat.format(outDouble));
    }
}
