package com.app.spring.angular.course.SpringAngularCourse.student;

import com.app.spring.angular.course.SpringAngularCourse.SpringAngularCourseApplication;
import com.app.spring.angular.course.SpringAngularCourse.base.AbstratcTest;
import com.app.spring.angular.course.SpringAngularCourse.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by jose de leon on 4/29/2021.
 */
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = SpringAngularCourseApplication.class)
@AutoConfigureMockMvc
class StudentRestControllerTest extends AbstratcTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Executing test method givenStudent_whenGetAllStudentJpa_thenStatus200 ")
    public void givenStudent_whenGetAllStudentJpa_thenStatus200()
            throws Exception {
        String uri = "/student";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Student[] studentList = mapFromJson(content, Student[].class);
        assertTrue(studentList.length > 0);
    }

    @Test
    @DisplayName("Executing test method givenStudent_whenGetAllStudentJdbc_thenStatus200 ")
    public void givenStudent_whenGetAllStudentJdbc_thenStatus200()
            throws Exception {
        String uri = "/student/jdbc";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Student[] studentList = mapFromJson(content, Student[].class);
        assertTrue(studentList.length > 0);
    }

}
