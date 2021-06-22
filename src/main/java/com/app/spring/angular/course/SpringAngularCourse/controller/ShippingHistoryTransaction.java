package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.dto.CounterResponseDto;
import com.app.spring.angular.course.SpringAngularCourse.dto.ShippingHistoryResponseDto;
import com.app.spring.angular.course.SpringAngularCourse.service.ShippingHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by jose de leon on 6/20/2021.
 */
@RestController
@RequestMapping("/shipping/history")
public class ShippingHistoryTransaction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ShippingHistoryService shippingHistoryService;

    @Autowired
    public ShippingHistoryTransaction(ShippingHistoryService shippingHistoryService){
        this.shippingHistoryService = shippingHistoryService;
    }

    @GetMapping
    public ResponseEntity<List<ShippingHistoryResponseDto>> getShippingHistoryTransaction(@RequestParam("page") int page,
                                                                                          @RequestParam("size") int size){
        Pageable pageable = PageRequest.of(page,size, Sort.by("id").descending());
        List<ShippingHistoryResponseDto> transactions = shippingHistoryService.findShippingTransaction(pageable);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/count")
    public ResponseEntity<CounterResponseDto> getShippingHistoryTransaction(@RequestParam("size") int size){
        CounterResponseDto response = shippingHistoryService.ShippingTransactionCounter(size);
        return ResponseEntity.ok(response);
    }

}