package com.app.spring.angular.course.SpringAngularCourse.service;

import com.app.spring.angular.course.SpringAngularCourse.dto.TransactionStatusDto;
import com.app.spring.angular.course.SpringAngularCourse.exception.EmployeeNotFoundException;
import com.app.spring.angular.course.SpringAngularCourse.exception.TransactionFailException;
import com.app.spring.angular.course.SpringAngularCourse.jparepository.EmployeeRepository;
import com.app.spring.angular.course.SpringAngularCourse.jparepository.TransactionHistoryRepository;
import com.app.spring.angular.course.SpringAngularCourse.model.Employee;
import com.app.spring.angular.course.SpringAngularCourse.model.FullTimeEmployee;
import com.app.spring.angular.course.SpringAngularCourse.model.TransactionHistory;
import com.app.spring.angular.course.SpringAngularCourse.utils.CodeGenerationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jose de leon on 5/17/2021.
 */
@Service
public class CurrencyTransactionService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private TransactionHistoryRepository transactionHistoryRepository;

    private EmployeeRepository employeeRepository;

    @Autowired
    public CurrencyTransactionService(EmployeeRepository employeeRepository, TransactionHistoryRepository transactionHistoryRepository){
        this.employeeRepository = employeeRepository;
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    @Transactional
    public TransactionStatusDto transferBetweenEmployees(Long employeeDebtId, Long employeeReceiveId, BigDecimal amount) {

        logger.info("Entering in transferBetweenEmployees");
        logger.info("param employeeDebtId: "+employeeDebtId);
        logger.info("param employeeReciveId: "+employeeReceiveId);
        logger.info("param amount: "+amount);

        logger.info("find debt");
        FullTimeEmployee employeeDebt =(FullTimeEmployee) employeeRepository.findEmployeeById(employeeDebtId).orElseThrow(() -> new EmployeeNotFoundException());
        BigDecimal amountR = employeeDebt.getWalletAmount().subtract(amount);

        if(amountR.intValue()<  0){
            throw new TransactionFailException();
        }

        employeeDebt.setWalletAmount(amountR);
        logger.info("param employeeDebt: "+employeeDebt);

        logger.info("do receive");
        Employee employeeReceive = employeeRepository.findEmployeeById(employeeReceiveId).orElseThrow(() -> new EmployeeNotFoundException());
        amountR = employeeReceive.getWalletAmount().add(amount);
        employeeReceive.setWalletAmount(amountR);
        logger.info("param employeeReceive: "+employeeReceive);

        TransactionStatusDto statusDto =new  TransactionStatusDto();
        statusDto.setResult(TransactionStatusDto.SUCCESS);
        statusDto.setTransactionId(CodeGenerationUtil.stringUUIDGenerator());

        TransactionHistory history = new TransactionHistory();
        history.setCode(statusDto.getTransactionId());
        history.setStatus(TransactionStatusDto.SUCCESS);
        history.setAmount(amount);
        history.setUserDebt(String.format("%s:%s:%s", employeeDebt.getId(), employeeDebt.getEmployeeCode(), employeeDebt.getName()));
        history.setUserReceive(String.format("%s:%s:%s", employeeReceive.getId(), employeeReceive.getEmployeeCode(), employeeReceive.getName()));

        transactionHistoryRepository.save(history);

        return statusDto;
    }

    public List<TransactionHistory> getHistoryOfTransaction(String nameFilter, Pageable page) {
        return transactionHistoryRepository.findByTransactionUser(nameFilter, page);
    }
}
