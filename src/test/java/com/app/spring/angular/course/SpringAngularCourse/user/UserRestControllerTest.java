package com.app.spring.angular.course.SpringAngularCourse.user;

import com.app.spring.angular.course.SpringAngularCourse.base.AbstractRestTest;
import com.app.spring.angular.course.SpringAngularCourse.model.Customer;
import com.app.spring.angular.course.SpringAngularCourse.model.Role;
import com.app.spring.angular.course.SpringAngularCourse.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by jose de leon on 4/30/2021.
 */
public class UserRestControllerTest extends AbstractRestTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String ResourcePath = "/user";

    public User getMockAdminUser(){
        User user = new User();
        user.setUsername("Test");
        user.setEmail("Test@test.com");
        user.setCreationDay(new Date());
        user.setLastUpdate(new Date());
        user.setPassword("testPassword");
        user.setStatus("ACTIVE");
        Role role = new Role(1L);
        user.setRole(role);
        Customer customer = new Customer();
        customer.setAddress("Test Address");
        customer.setBirthday(new Date());
        customer.setFirstName("Test Customer name");
        customer.setLastName("Test customer last name");
        customer.setCustomerCode("TestCode1");
        user.setCustomer(customer);
        return user;
    }

    @Test
    @DisplayName("Executing test method tryToFoundDefaultUserAdminByName_thenStatus200 ")
    @Order(1)
    public void tryToFoundDefaultUserAdminByName_thenStatus200()
            throws Exception {
        String uri = ResourcePath+"/find";
        String usernameParma ="?username=admin";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri+ usernameParma)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    @DisplayName("Executing test method tryToFoundDefaultUserAdminByEmail_thenStatus200 ")
    @Order(2)
    public void tryToFoundDefaultUserAdminByEmail_thenStatus200()
            throws Exception {
        String uri = ResourcePath+"/find";

        String emailParam ="?email=SysAdmin@admin.com";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri+ emailParam)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    @DisplayName("Executing test method tryToCreateNewUser_thenStatus200 ")
    @Order(3)
    public void tryToCreateNewUser_thenStatus200()
            throws Exception {
        String uri = ResourcePath+"/create";

        User user =  getMockAdminUser();

        logger.info("User created : "+ user);

        String Json  = mapToJson(user);
        logger.info("User Json  : "+ Json);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .content(mapToJson(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        UserJson studentList = mapFromJson(content, UserJson.class);
        assertEquals( studentList.getUsername() , "Test");
    }

    @Test
    @DisplayName("Executing test method tryToUpdateExistenceUser_thenStatus200 ")
    @Order(4)
    public void tryToUpdateExistenceUser_thenStatus200()
            throws Exception {
        //----- Created
        String uriCreated = ResourcePath+"/create";
        User userC =  getMockAdminUser();
        logger.info("User created : "+ userC);
        String Json  = mapToJson(userC);
        logger.info("User Json  : "+ Json);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uriCreated)
                .content(mapToJson(userC))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        UserJson studentFound = mapFromJson(content, UserJson.class);

        //----- Update
        String uriUpdate = ResourcePath+"/update";
        User user = getMockAdminUser();
        user.setId(studentFound.getId());
        user.getRole().setId(studentFound.getRole().getId());
        user.getCustomer().setId(studentFound.getCustomer().getId());
        user.setEmail("UpdateTest@test.com");

         mvcResult = mvc.perform(MockMvcRequestBuilders.put(uriUpdate)
                .content(mapToJson(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        status = mvcResult.getResponse().getStatus();

        assertEquals(200, status);
        content = mvcResult.getResponse().getContentAsString();
        UserJson studentList = mapFromJson(content, UserJson.class);
        assertEquals( studentList.getEmail() , "UpdateTest@test.com");
    }

    @Test
    @DisplayName("Executing test method tryToDeleteExistenceUser_thenStatus200 ")
    @Order(5)
    public void tryToDeleteExistenceUser_thenStatus200()
            throws Exception {


        String uriDelete = ResourcePath+"/delete";

        String uriFind = ResourcePath+"/find?username=Test";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uriFind)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        UserJson studentFound = mapFromJson(content, UserJson.class);
        assertEquals( studentFound.getUsername() , "Test");

        mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uriDelete+"/"+ studentFound.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

}