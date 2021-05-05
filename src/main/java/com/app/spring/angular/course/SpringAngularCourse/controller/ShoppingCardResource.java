package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.dto.PaymentRequestDto;
import com.app.spring.angular.course.SpringAngularCourse.dto.ShippingRequestDto;
import com.app.spring.angular.course.SpringAngularCourse.dto.ShoppingCardPreviewDto;
import com.app.spring.angular.course.SpringAngularCourse.dto.ShoppingCardResponseDto;
import com.app.spring.angular.course.SpringAngularCourse.service.ShoppingCardService;
import com.app.spring.angular.course.SpringAngularCourse.utils.CodeGenerationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jose de leon on 5/3/2021.
 */
@RestController
@RequestMapping("/shopping/card")
public class ShoppingCardResource {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ShoppingCardService shoppingCardService;

    @Autowired
    public ShoppingCardResource(ShoppingCardService shoppingCardService){
        this.shoppingCardService = shoppingCardService;
    }

    @PostMapping("/add/preview")
    public ResponseEntity<ShoppingCardResponseDto> registerPreview(@RequestBody ShoppingCardPreviewDto shoppingCardPreviewDto){
        logger.info("Entering in Post : registerPreview");
        shoppingCardPreviewDto.setOrderCode(CodeGenerationUtil.StringCodeGenerated(8));
        shoppingCardPreviewDto.setOrderNumber("N-"+CodeGenerationUtil.StringCodeGenerated(4) );
        logger.info("Param Entry : "+ shoppingCardPreviewDto);
        ShoppingCardResponseDto shoppingCardPreview = shoppingCardService.createPreviewTransaction(shoppingCardPreviewDto);
        logger.info("Exiting in Post : registerPreview");
        return ResponseEntity.ok(shoppingCardPreview);
    }

    @PutMapping("/update/shipping")
    public ResponseEntity<?> updateShipping(@RequestBody ShippingRequestDto shippingRequestDto){
        logger.info("Entering in Post : updateShipping");
        shippingRequestDto.setShippingCode(CodeGenerationUtil.StringCodeGenerated(8));
        logger.info("Param Entry : "+ shippingRequestDto);
        shoppingCardService.updateShippingTransaction(shippingRequestDto);
        logger.info("Exiting in Post : updateShipping");
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/payment")
    public ResponseEntity<?> updatePayment(@RequestBody PaymentRequestDto paymentRequestDto){
        logger.info("Entering in Post : updatePayment");
        logger.info("Param Entry : "+ paymentRequestDto);
        shoppingCardService.updatePaymentInfoTransaction(paymentRequestDto);
        logger.info("Exiting in Post : updatePayment");
        return ResponseEntity.ok().build();
    }

}
