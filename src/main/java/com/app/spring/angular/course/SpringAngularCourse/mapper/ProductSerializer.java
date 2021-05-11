package com.app.spring.angular.course.SpringAngularCourse.mapper;

import com.app.spring.angular.course.SpringAngularCourse.model.Product;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * Created by jose de leon on 5/11/2021.
 */
public class ProductSerializer extends StdSerializer<Product> {

    public ProductSerializer() {
        this(null);
    }

    public ProductSerializer(Class<Product> t) {
        super(t);
    }


    @Override
    public void serialize(Product product, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", product.getId());
        jsonGenerator.writeStringField("name", product.getName());
        jsonGenerator.writeStringField("description"  , product.getDescription());
        jsonGenerator.writeStringField("productCode", product.getProductCode());

        //category
        jsonGenerator.writeObjectFieldStart("category");
        jsonGenerator.writeNumberField("id", product.getCategory().getId());
        jsonGenerator.writeStringField("name", product.getCategory().getName());
        jsonGenerator.writeStringField("code",  product.getCategory().getCode());
        jsonGenerator.writeBooleanField("active",  product.getCategory().isActive());

        jsonGenerator.writeEndObject();

        jsonGenerator.writeNumberField("price", product.getPrice());
        jsonGenerator.writeNumberField("discountPercent", product.getDiscountPercent());
        jsonGenerator.writeStringField("imagePath", product.getImagePath());

        //review
        if(product.getReview() != null && product.getReview().getId() != null){
            jsonGenerator.writeObjectFieldStart("review");
            jsonGenerator.writeNumberField("id", product.getReview().getId());
            jsonGenerator.writeNumberField("likeCounter", product.getReview().getLikeCounter());
            jsonGenerator.writeNumberField("dislikeCounter", product.getReview().getDislikeCounter());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndObject();

    }

}