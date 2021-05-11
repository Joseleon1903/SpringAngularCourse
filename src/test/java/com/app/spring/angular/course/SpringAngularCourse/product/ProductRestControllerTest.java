package com.app.spring.angular.course.SpringAngularCourse.product;

import com.app.spring.angular.course.SpringAngularCourse.base.AbstractRestTest;
import com.app.spring.angular.course.SpringAngularCourse.model.Category;
import com.app.spring.angular.course.SpringAngularCourse.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by jose de leon on 5/11/2021.
 */
public class ProductRestControllerTest extends AbstractRestTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String ResourcePath = "/product";

    public Product getMockProductJson(){
        Product product = new Product();
        product.setId(0L);
        product.setDescription("Test Description");
        product.setName("Test Name");
        product.setProductCode("TEST-7896632");
        product.setPrice(25.30D);
        product.setDiscountPercent(10.10D);
        product.setImagePath("www.testImage.jpg");
        Category category = new Category();
        category.setId(5L);
        product.setCategory(category);
        return product;
    }

    @Test
    @DisplayName("Executing test method tryToGetAllProducts_thenStatus200 ")
    @Order(1)
    public void tryToGetAllProducts_thenStatus200()
            throws Exception {
        String uri = ResourcePath;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Product[] products = mapFromJson(content, Product[].class);
        assertTrue(products.length > 0);
    }

    @Test
    @DisplayName("Executing test method tryToGetProductByCategory_thenStatus200 ")
    @Order(2)
    public void tryToGetProductByCategory_thenStatus200()
            throws Exception {
        String uri = ResourcePath+ "/category/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        Product[] product = mapFromJson(content, Product[].class);
        assertTrue(product.length > 0);
        assertEquals(product[0].getCategory().getId(), 1L);
    }

    @Test
    @DisplayName("Executing test method tryToPutProductUpdate_thenStatus200 ")
    @Order(3)
    public void tryToPutProductUpdate_thenStatus200()
            throws Exception {

        //find product
        String productIdParam ="?productId=1";
        String uri = ResourcePath+"/search"+ productIdParam;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Product product = mapFromJson(content, Product.class);
        assertEquals(product.getId(), 1L);

        //modify product
        String newName= "Changed name test";
        product.setName(newName);
        String uriPut = ResourcePath;
        String putContent = mapToJson(product);
        mvcResult = mvc.perform(MockMvcRequestBuilders.put(uriPut)
                .content(putContent)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        content = mvcResult.getResponse().getContentAsString();
        Product productPut = mapFromJson(content, Product.class);
        assertEquals(productPut.getName(), newName);
    }

    @Test
    @DisplayName("Executing test method tryToFindProductById_thenStatus200 ")
    @Order(4)
    public void tryToFindProductById_thenStatus200()
            throws Exception {

        String productIdParam ="?productId=1";
        String uri = ResourcePath+"/search"+ productIdParam;

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Product product = mapFromJson(content, Product.class);
        assertEquals(product.getId(), 1L);
    }

    @Test
    @DisplayName("Executing test method tryToCreateNewProduct_thenStatus201")
    @Order(5)
    public void tryToCreateNewProduct_thenStatus201()
            throws Exception {
        String uri = ResourcePath+ "/create";
        logger.info("****** URI INFO: "+uri);
        String productJson = mapToJson(getMockProductJson());
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).content(productJson)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }

}
