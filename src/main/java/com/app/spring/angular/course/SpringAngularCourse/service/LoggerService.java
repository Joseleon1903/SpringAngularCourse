package com.app.spring.angular.course.SpringAngularCourse.service;

import com.app.spring.angular.course.SpringAngularCourse.controller.IResourceController;
import com.app.spring.angular.course.SpringAngularCourse.jdbcrepository.DbLoggerJdbcDao;
import com.app.spring.angular.course.SpringAngularCourse.utils.CodeGenerationUtil;
import org.springframework.stereotype.Service;

/**
 * Created by jose de leon on 7/31/2021.
 */
@Service
public class LoggerService {

    private DbLoggerJdbcDao dbLoggerJdbcDao;

    public LoggerService(DbLoggerJdbcDao dbLoggerJdbcDao){
        this.dbLoggerJdbcDao= dbLoggerJdbcDao;
    }

    public void putLogDatabase(String text, IResourceController resourceClass, String serviceName){
        String reference = CodeGenerationUtil.stringUUIDGenerator();
        String classNameT = resourceClass.getName();
        dbLoggerJdbcDao.insertDatabaseLog(text, classNameT, serviceName,reference );
    }

}