package com.app.spring.angular.course.SpringAngularCourse.student;

import com.app.spring.angular.course.SpringAngularCourse.jdbcrepository.StudentJdbcDao;
import com.app.spring.angular.course.SpringAngularCourse.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import java.util.List;
import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Created by jose de leon on 4/28/2021.
 */
@SpringBootTest
public class StudentJdbcRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @Order(1)
    @DisplayName("start test method givenStudentInsertDatabaseTest")
    public void givenStudentInsertDatabaseTest()
            throws Exception {
        logger.info("Entering in method givenStudentInsertDatabaseTest");
        StudentJdbcDao studentJdbcDao= new StudentJdbcDao(jdbcTemplate);
        Student student = new Student();
        student.setId(20L);
        student.setFirstName("Student Test");
        student.setLastName("Student last name test");
        student.setEmail("student@test.com");
        student.setAge(25);
        int result = studentJdbcDao.insert(student);
        logger.info("Exiting in method givenStudentInsertDatabaseTest");
        assertEquals("givenStudentInsertDatabaseTest successfully", result, 1);
    }

    @Test
    @Order(2)
    @DisplayName("start test method givenStudentSelectByIdDatabaseTest")
    public void givenStudentSelectByIdDatabaseTest()
            throws Exception {
        StudentJdbcDao studentJdbcDao = new StudentJdbcDao(jdbcTemplate);
        Student student = studentJdbcDao.findById(1L);
        assertEquals("givenStudentSelectByIdDatabaseTest successfully", student.getId(), 1L);
    }

    @Test
    @Order(3)
    @DisplayName("start test method givenStudentSelectAllDatabaseTest")
    public void givenStudentSelectAllDatabaseTest()
            throws Exception {
        StudentJdbcDao studentJdbcDao = new StudentJdbcDao(jdbcTemplate);
        List<Student> students = studentJdbcDao.findAllStudent();
        assertEquals("givenStudentSelectByIdDatabaseTest successfully", students.size() > 0, true);
    }

    @Test
    @Order(4)
    @DirtiesContext
    @DisplayName("start test method givenStudentDeleteByIdDatabaseTest")
    public void givenStudentDeleteByIdDatabaseTest()
            throws Exception {
        StudentJdbcDao studentJdbcDao = new StudentJdbcDao(jdbcTemplate);
        int student = studentJdbcDao.deleteById(1L);
        assertEquals("givenStudentSelectByIdDatabaseTest successfully", student, 1);
    }

    @Test
    @Order(4)
    @DisplayName("start test method givenStudentUpdateDatabaseTest")
    public void givenStudentUpdateDatabaseTest()
            throws Exception {
        StudentJdbcDao studentJdbcDao = new StudentJdbcDao(jdbcTemplate);
        Student student = studentJdbcDao.findById(2L);
        student.setLastName("UpdatedLastName");
        int updateN = studentJdbcDao.update(student);
        assertEquals("givenStudentUpdateDatabaseTest successfully", updateN, 1);
    }
}
