package com.app.spring.angular.course.SpringAngularCourse.service;

import com.app.spring.angular.course.SpringAngularCourse.dto.*;
import com.app.spring.angular.course.SpringAngularCourse.jparepository.*;
import com.app.spring.angular.course.SpringAngularCourse.mapper.CustomerOrderSerializer;
import com.app.spring.angular.course.SpringAngularCourse.model.*;
import com.app.spring.angular.course.SpringAngularCourse.utils.ShoppingUtilies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose de leon on 5/3/2021.
 */
@Service
@Transactional
public class ShoppingCardService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final EmployeeRepository employeeRepository;

    private final CustomerRepository customerRepository;

    private final CustomerOrderRepository customerOrderRepository;

    private final OrderStatusRepository orderStatusRepository;

    private final ProductRepository productRepository;

    private final DestinationRepository destinationRepository;

    @Autowired
    public ShoppingCardService(EmployeeRepository employeeRepository, CustomerRepository customerRepository, CustomerOrderRepository customerOrderRepository,
                               OrderStatusRepository orderStatusRepository, ProductRepository productRepository, DestinationRepository destinationRepository) {
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
        this.customerOrderRepository = customerOrderRepository;
        this.orderStatusRepository= orderStatusRepository;
        this.productRepository = productRepository;
        this.destinationRepository = destinationRepository;
    }

    public ShoppingCardResponseDto createPreviewTransaction(ShoppingCardPreviewDto shoppingCardPreviewDto) {
        logger.info("Entering in shoppingCardPreviewDto");

        logger.info("find employee transaction ");
        Employee tEmplyee = employeeRepository.findEmployeeById(shoppingCardPreviewDto.getEmployeeId()).get();
        logger.info("find customer transaction ");
        Customer tCustomer = customerRepository.findById(shoppingCardPreviewDto.getCustomerId()).get();
        logger.info("find status transaction ");
        OrderStatus tStatus= orderStatusRepository.findById(shoppingCardPreviewDto.getOrderStatusId()).get();
        CustomerOrder newOrder = new CustomerOrder();
        logger.info("find products transaction ");
        List<Product> entityProducts = new ArrayList<>();
        for (ProductDto prod : shoppingCardPreviewDto.getProducts()){

            Product product = productRepository.findById(prod.getProductId()).get();
            entityProducts.add(product);
        }
        logger.info("create new order transaction ");

        newOrder.setOrderCode(shoppingCardPreviewDto.getOrderCode());
        newOrder.setOrderNumber(shoppingCardPreviewDto.getOrderNumber());
        newOrder.setCustomer(tCustomer);
        newOrder.setEmployee(tEmplyee);
        newOrder.setOrderStatus(tStatus);

        logger.info("create order detail transaction ");
        OrderDetail detail = new OrderDetail();
        detail.setDescription(String.format("Customer %s accept to make an order number %s with code %s by employee %s",tCustomer.getFirstName()+" "+ tCustomer.getLastName(),
                shoppingCardPreviewDto.getOrderNumber(),
                shoppingCardPreviewDto.getOrderCode(),
                tEmplyee.getName()));

        detail.getProducts().addAll(entityProducts);
        Double totalProductsPrice = ShoppingUtilies.getTotalProductPrice(entityProducts);
        detail.setProductTotalPrice(totalProductsPrice);
        Double taxCharge = ShoppingUtilies.getTaxCharge(totalProductsPrice);
        detail.setTaxCharge(taxCharge);
        detail.setTotalPrice(ShoppingUtilies.getFinalPrice(totalProductsPrice, taxCharge));

        logger.info("order detail transaction:  " + detail);

        newOrder.setOrderDetail(detail);

        logger.info("order transaction:  " + newOrder);

        customerOrderRepository.save(newOrder);

        ShoppingCardResponseDto response =  new ShoppingCardResponseDto();
        response.setOrderCode(shoppingCardPreviewDto.getOrderCode());
        response.setOrderNumber(shoppingCardPreviewDto.getOrderNumber());
        response.setProducts(shoppingCardPreviewDto.getProducts());
        response.setTaxCharge(taxCharge);
        response.setTotalPrice(ShoppingUtilies.getFinalPrice(totalProductsPrice, taxCharge));
        response.setStatus(newOrder.getOrderStatus().getName());
        response.setProductTotalPrice(totalProductsPrice);

        return response;
    }

    public void updateShippingTransaction(ShippingRequestDto shippingRequestDto) {
        logger.info("Entering in method updateShippingTransaction");

        logger.info("found customer order");
        CustomerOrder customerOrder = customerOrderRepository.findByOrderCode(shippingRequestDto.getOrderCode()).get();
        logger.info("found destination");
        Destination destin = destinationRepository.findById(shippingRequestDto.getDestinationId()).get();

        ShippingDetail shippingD = new ShippingDetail();

        LocalDateTime dateTime = LocalDateTime.parse(shippingRequestDto.getDeliveryDate(), CustomerOrderSerializer.formatter);

        shippingD.setCode(shippingRequestDto.getShippingCode());
        shippingD.setDeliveryDate(dateTime);
        shippingD.setDestinationAddress(destin.getAddress());
        shippingD.setDestination(destin);
        shippingD.setShippingCharge(destin.getCharge());

        logger.info("Detail shipping : "+ shippingD);
        customerOrder.setShippingDetail(shippingD);
    }

    public void updatePaymentInfoTransaction(PaymentRequestDto paymentRequestDto) {
        logger.info("Entering in method paymentRequestDto");
    }
}
