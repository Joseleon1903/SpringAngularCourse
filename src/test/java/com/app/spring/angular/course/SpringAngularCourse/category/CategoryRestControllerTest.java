package com.app.spring.angular.course.SpringAngularCourse.category;

import com.app.spring.angular.course.SpringAngularCourse.base.AbstractRestTest;
import com.app.spring.angular.course.SpringAngularCourse.model.Category;
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
 * Created by jose de leon on 4/30/2021.
 */
public class CategoryRestControllerTest extends AbstractRestTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String ResourcePath = "/category";

    @Test
    @DisplayName("Executing test method tryToGetAllCategory_thenStatus200 ")
    @Order(1)
    public void tryToGetAllCategory_thenStatus200()
            throws Exception {
        String uri = ResourcePath;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        Category[] destinations = mapFromJson(content, Category[].class);
        assertTrue(destinations.length > 0);
    }

}
