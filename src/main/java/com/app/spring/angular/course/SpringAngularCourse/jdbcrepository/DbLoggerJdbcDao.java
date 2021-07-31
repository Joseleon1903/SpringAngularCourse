package com.app.spring.angular.course.SpringAngularCourse.jdbcrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 * Created by jose de leon on 7/31/2021.
 */
@Repository
public class DbLoggerJdbcDao {

    private final JdbcTemplate jdbcTemplate;

    public static String INSERT_LOG_FUNCTION_NAME = "db_insert_log";

    @Autowired
    public DbLoggerJdbcDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertDatabaseLog(String texto, String className, String serviceName, String reference){

        SqlParameterSource parameterSQL = new MapSqlParameterSource()
                .addValue("p_texto", texto)
                .addValue("p_service_name", serviceName)
                .addValue("p_class_name", className)
                .addValue("p_reference", reference);

        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withFunctionName(INSERT_LOG_FUNCTION_NAME);
        int logId = simpleJdbcCall.executeFunction(int.class, parameterSQL);
        return logId;
    }


}
