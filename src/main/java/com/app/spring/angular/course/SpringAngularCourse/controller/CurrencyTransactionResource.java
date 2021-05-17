package com.app.spring.angular.course.SpringAngularCourse.controller;

import com.app.spring.angular.course.SpringAngularCourse.dto.TransactionStatusDto;
import com.app.spring.angular.course.SpringAngularCourse.model.TransactionHistory;
import com.app.spring.angular.course.SpringAngularCourse.service.CurrencyTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jose de leon on 5/17/2021.
 */
@RestController
@RequestMapping("/currency/transaction")
public class CurrencyTransactionResource {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private CurrencyTransactionService currencyTransactionService;

    @Autowired
    public CurrencyTransactionResource(CurrencyTransactionService currencyTransactionService){
        this.currencyTransactionService = currencyTransactionService;
    }

    @PutMapping("/transfer")
    public ResponseEntity<TransactionStatusDto> tranferBetweenEmployees(@RequestParam("employeeDebtId") Long employeeDebtId,
                                                                       @RequestParam("employeeReceiveId") Long employeeReciveId,
                                                                       @RequestParam("amount") BigDecimal amount){
        TransactionStatusDto response = currencyTransactionService.transferBetweenEmployees(employeeDebtId,employeeReciveId, amount );
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TransactionHistory>> getPaginatedTransactions(@RequestParam("page") int page,
                                                                             @RequestParam("size") int size,
                                                                             @RequestParam(value = "name", required = false) String name){
        PageRequest pages = PageRequest.of(page, size, Sort.by("amount").ascending());
        List<TransactionHistory> response = currencyTransactionService.getHistoryOfTransaction(name, pages);
        return ResponseEntity.ok(response);
    }

}