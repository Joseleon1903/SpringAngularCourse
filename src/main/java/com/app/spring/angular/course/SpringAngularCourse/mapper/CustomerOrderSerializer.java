package com.app.spring.angular.course.SpringAngularCourse.mapper;

import com.app.spring.angular.course.SpringAngularCourse.model.CustomerOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

/**
 * Created by jose de leon on 5/4/2021.
 */
public class CustomerOrderSerializer extends StdSerializer<CustomerOrder> {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public CustomerOrderSerializer() {
        this(null);
    }

    public CustomerOrderSerializer(Class<CustomerOrder> t) {
        super(t);
    }


    @Override
    public void serialize(CustomerOrder customerOrder, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();

        jsonGenerator.writeNumberField("id", customerOrder.getId());
        jsonGenerator.writeStringField("orderCode", customerOrder.getOrderCode());
        jsonGenerator.writeStringField("orderNumber", customerOrder.getOrderNumber());
        String parseCreationDateFormat = customerOrder.getCreationDate().format(formatter);
        String parseUpdateDateFormat = customerOrder.getLastUpdateDate().format(formatter);
        jsonGenerator.writeStringField("creationDate", parseCreationDateFormat);
        jsonGenerator.writeStringField("lastUpdateDate", parseUpdateDateFormat);

        //customer
        jsonGenerator.writeObjectFieldStart("customer");
        jsonGenerator.writeNumberField("customerId", customerOrder.getCustomer().getId());
        jsonGenerator.writeStringField("customerCode", customerOrder.getCustomer().getCustomerCode());
        jsonGenerator.writeStringField("firstName", customerOrder.getCustomer().getFirstName());
        jsonGenerator.writeStringField("lastName", customerOrder.getCustomer().getLastName());
        jsonGenerator.writeStringField("address", customerOrder.getCustomer().getAddress());
        String parseDateFormat = FORMATTER.format(customerOrder.getCustomer().getBirthday().getTime());
        jsonGenerator.writeStringField("birthday", parseDateFormat);
        jsonGenerator.writeEndObject();

        //employee
        jsonGenerator.writeObjectFieldStart("employee");
        jsonGenerator.writeNumberField("employeeId", customerOrder.getEmployee().getId());
        jsonGenerator.writeStringField("employeeCode", customerOrder.getEmployee().getEmployeeCode());
        jsonGenerator.writeStringField("name", customerOrder.getEmployee().getName());
        jsonGenerator.writeStringField("email", customerOrder.getEmployee().getEmail());
        jsonGenerator.writeStringField("jobTitle", customerOrder.getEmployee().getJobTittle());
        jsonGenerator.writeStringField("phone", customerOrder.getEmployee().getPhone());
        jsonGenerator.writeStringField("imageUrl", customerOrder.getEmployee().getImageUrl());
        jsonGenerator.writeEndObject();

        // order detail
        jsonGenerator.writeObjectFieldStart("orderDetail");
        jsonGenerator.writeNumberField("id", customerOrder.getOrderDetail().getId());
        jsonGenerator.writeStringField("description", customerOrder.getOrderDetail().getDescription());
//        jsonGenerator.writeNumberField("productSize", customerOrder.getOrderDetail().getProducts().size());
        jsonGenerator.writeNumberField("productTotalPrice", customerOrder.getOrderDetail().getProductTotalPrice());
        jsonGenerator.writeNumberField("taxCharge", customerOrder.getOrderDetail().getTaxCharge());
        jsonGenerator.writeNumberField("totalPrice", customerOrder.getOrderDetail().getTotalPrice());
        jsonGenerator.writeEndObject();

        //shipping detail
        if(customerOrder.getShippingDetail() != null){
            jsonGenerator.writeObjectFieldStart("shippingDetail");
            jsonGenerator.writeNumberField("id", customerOrder.getShippingDetail().getId());
            jsonGenerator.writeStringField("code", customerOrder.getShippingDetail().getCode());
            jsonGenerator.writeStringField("destinationAddress",  customerOrder.getShippingDetail().getDestinationAddress());
            String parseDeliveryDateFormat = customerOrder.getShippingDetail().getDeliveryDate().format(formatter);
            jsonGenerator.writeStringField("deliveryDate",parseDeliveryDateFormat);
            jsonGenerator.writeNumberField("destinationId", customerOrder.getShippingDetail().getDestination().getId());
            jsonGenerator.writeNumberField("shippingCharge",  customerOrder.getShippingDetail().getShippingCharge());
            jsonGenerator.writeEndObject();
        }

        jsonGenerator.writeStringField("orderStatus", customerOrder.getOrderStatus().getName());

        jsonGenerator.writeEndObject();

    }
}

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name="shipping_detail_id")
//    private ShippingDetail shippingDetail;