package com.app.spring.angular.course.SpringAngularCourse.mapper;

import com.app.spring.angular.course.SpringAngularCourse.model.Customer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by jose de leon on 4/30/2021.
 */
public class CustomerSerializer extends StdSerializer<Customer> {

    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public CustomerSerializer() {
        this(null);
    }

    public CustomerSerializer(Class<Customer> t) {
        super(t);
    }


    @Override
    public void serialize(Customer customer, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", customer.getId());
        jsonGenerator.writeStringField("customerCode", customer.getCustomerCode());
        jsonGenerator.writeStringField("firstName"  , customer.getFirstName());
        jsonGenerator.writeStringField("lastName", customer.getLastName());
        jsonGenerator.writeStringField("address", customer.getAddress());
        String parseDateFormat =FORMATTER.format(customer.getBirthday().getTime());
        jsonGenerator.writeStringField("birthday",parseDateFormat );
        if(customer.getUser() != null){
            jsonGenerator.writeNumberField("userId", customer.getUser().getId());
        }
        jsonGenerator.writeEndObject();

    }

}
