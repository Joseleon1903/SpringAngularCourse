package com.app.spring.angular.course.SpringAngularCourse.service;

import com.app.spring.angular.course.SpringAngularCourse.dto.*;
import com.app.spring.angular.course.SpringAngularCourse.exception.*;
import com.app.spring.angular.course.SpringAngularCourse.jparepository.*;
import com.app.spring.angular.course.SpringAngularCourse.mapper.CustomerOrderSerializer;
import com.app.spring.angular.course.SpringAngularCourse.model.*;
import com.app.spring.angular.course.SpringAngularCourse.utils.ShoppingUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
        Employee tEmplyee = employeeRepository.findEmployeeById(shoppingCardPreviewDto.getEmployeeId()).orElseThrow(() -> new EmployeeNotFoundException());

        logger.info("find customer transaction ");
        Customer tCustomer = customerRepository.findById(shoppingCardPreviewDto.getCustomerId()).orElseThrow(() -> new CustomerNotFoundException());
        logger.info("find status transaction ");
        OrderStatus tStatus= orderStatusRepository.findById(shoppingCardPreviewDto.getOrderStatusId()).get();
        CustomerOrder newOrder = new CustomerOrder();
        logger.info("find products transaction ");
        List<Product> entityProducts = new ArrayList<>();

        if(productRepository.findById(shoppingCardPreviewDto.getProductId()).isPresent()){
            Product product =productRepository.findById(shoppingCardPreviewDto.getProductId()).get();
            entityProducts.add(product);
        }

        logger.info("create new order transaction ");

        if(entityProducts.size() == 0){
            throw new CheckoutProductNotFoundException();
        }

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
        BigDecimal totalProductsPrice = ShoppingUtilities.getTotalProductPrice(entityProducts);
        detail.setProductTotalPrice(totalProductsPrice);
        BigDecimal taxCharge = ShoppingUtilities.getTaxCharge(totalProductsPrice);
        detail.setTaxCharge(taxCharge);
        detail.setTotalPrice(ShoppingUtilities.getFinalPrice(totalProductsPrice, taxCharge));

        logger.info("order detail transaction:  " + detail);

        newOrder.setOrderDetail(detail);

        logger.info("order transaction:  " + newOrder);

        customerOrderRepository.save(newOrder);

        ShoppingCardResponseDto response =  new ShoppingCardResponseDto();
        response.setOrderCode(shoppingCardPreviewDto.getOrderCode());
        response.setOrderNumber(shoppingCardPreviewDto.getOrderNumber());
        response.setProductId(shoppingCardPreviewDto.getProductId());
        response.setTaxCharge(taxCharge);
        response.setTotalPrice(ShoppingUtilities.getFinalPrice(totalProductsPrice, taxCharge));
        response.setStatus(newOrder.getOrderStatus().getName());
        response.setProductTotalPrice(totalProductsPrice);

        return response;
    }

    public void updateShippingTransaction(ShippingRequestDto shippingRequestDto) {
        logger.info("Entering in method updateShippingTransaction");

        logger.info("found customer order");
        CustomerOrder customerOrder = customerOrderRepository.findByOrderCode(shippingRequestDto.getOrderCode()).orElseThrow( () -> new CustomerOrderNotFoundException());
        logger.info("found destination");
        Destination destin = destinationRepository.findById(shippingRequestDto.getDestinationId()).orElseThrow( () -> new DestinationNotFoundException());

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
        logger.info("param: "+ paymentRequestDto);

        logger.info("Found Customer Order ");

        CustomerOrder customOrder = customerOrderRepository.findByOrderCode(paymentRequestDto.getOrderCode()).orElseThrow( () -> new CustomerOrderNotFoundException());

        logger.info("change status Customer Order ");

        OrderStatus newStatus = orderStatusRepository.findById(2L).get();
        customOrder.setOrderStatus(newStatus);

        PaymentInfo info = new PaymentInfo();
        info.setCardType(CardType.MASTERCARD);
        info.setPaymentType(PaymentType.CREDIT_CARD);
        info.setAccountNumber(paymentRequestDto.getAccountNumber());
        info.setCardNumber(paymentRequestDto.getCardNumber());
        info.setCardHolderName(paymentRequestDto.getCardHolderName());
        info.setComment(paymentRequestDto.getComment());
        info.setExpireDate(paymentRequestDto.getExpireDate());

        customOrder.setPaymentInfo(info);
    }

}