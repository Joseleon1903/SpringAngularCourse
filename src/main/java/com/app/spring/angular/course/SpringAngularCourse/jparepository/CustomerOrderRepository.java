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
            "detail.totalPrice, info.cardType, info.paymentType, " +
            "ship.code, ship.deliveryDate, dest.name ) FROM CustomerOrder order " +
            "LEFT JOIN FETCH OrderDetail detail ON order.id = detail.id " +
            "LEFT JOIN FETCH Destination dest ON detail.id = dest.id " +
            "LEFT JOIN FETCH ShippingDetail ship ON order.id = ship.id "+
            "LEFT JOIN FETCH PaymentInfo info ON order.id = info.id";

    String CustomersShippingTransactionCounterQuery = "select count(*) from CustomerOrder" ;


    @Query(FindCustomersShippingTransactionQuery)
    List<ShippingHistoryResponseDto> findCustomersShippingTransaction(Pageable pageable);

    @Query(CustomersShippingTransactionCounterQuery)
    long countCustomersShippingTransaction();

    Optional<CustomerOrder> findByOrderCode(String code);

}
