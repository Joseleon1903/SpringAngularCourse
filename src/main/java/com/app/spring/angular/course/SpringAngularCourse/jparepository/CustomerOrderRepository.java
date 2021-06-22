package com.app.spring.angular.course.SpringAngularCourse.jparepository;

import com.app.spring.angular.course.SpringAngularCourse.dto.ShippingHistoryResponseDto;
import com.app.spring.angular.course.SpringAngularCourse.model.CustomerOrder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

/**
 * Created by jose de leon on 5/3/2021.
 */
public interface CustomerOrderRepository  extends JpaRepository<CustomerOrder, Long> {


    String FindCustomersShippingTransactionQuery = "SELECT " +
            "new com.app.spring.angular.course.SpringAngularCourse.dto.ShippingHistoryResponseDto" +
            "(order.orderCode, order.orderNumber, order.creationDate, order.orderStatus.name, order.customer.customerCode, order.employee.employeeCode, " +
            "order.orderDetail.totalPrice, order.paymentInfo.cardType, order.paymentInfo.paymentType, " +
            "order.shippingDetail.code,order.shippingDetail.deliveryDate, order.shippingDetail.destination.name ) FROM CustomerOrder order";

    @Query(FindCustomersShippingTransactionQuery)
    List<ShippingHistoryResponseDto> findCustomersShippingTransaction(Pageable pageable);

    Optional<CustomerOrder> findByOrderCode(String code);

}
