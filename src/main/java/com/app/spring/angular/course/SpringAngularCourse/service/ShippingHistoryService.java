package com.app.spring.angular.course.SpringAngularCourse.service;

import com.app.spring.angular.course.SpringAngularCourse.dto.CounterResponseDto;
import com.app.spring.angular.course.SpringAngularCourse.dto.ShippingHistoryResponseDto;
import com.app.spring.angular.course.SpringAngularCourse.jparepository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jose de leon on 6/20/2021.
 */
@Service
@Transactional
public class ShippingHistoryService {

    private final CustomerOrderRepository customerOrderRepository;

    @Autowired
    public ShippingHistoryService(CustomerOrderRepository customerOrderRepository){
        this.customerOrderRepository= customerOrderRepository;
    }

    public List<ShippingHistoryResponseDto> findShippingTransaction(Pageable pageable) {
        return customerOrderRepository.findCustomersShippingTransaction(pageable);
    }

    public CounterResponseDto ShippingTransactionCounter(int size) {
       long countRow =  customerOrderRepository.countCustomersShippingTransaction();
        CounterResponseDto resp = new CounterResponseDto();
        resp.setTotalRow(countRow);
        if(size > countRow){
            resp.setRowRemain(0L);
            return resp;
        }
        resp.setRowRemain(countRow - size);
        return resp;
    }
}
