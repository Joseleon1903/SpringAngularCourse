package com.app.spring.angular.course.SpringAngularCourse.jdbcrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by jose de leon on 7/31/2021.
 */
@Repository

public class JdbcCommandExecutor {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcCommandExecutor(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void SqlExecute(String sqlSentence){
        jdbcTemplate.execute(sqlSentence);
    }

}