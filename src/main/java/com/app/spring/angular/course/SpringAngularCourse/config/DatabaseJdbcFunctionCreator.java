package com.app.spring.angular.course.SpringAngularCourse.config;

import com.app.spring.angular.course.SpringAngularCourse.jdbcrepository.JdbcCommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by jose de leon on 7/31/2021.
 */
@Profile("dev")
@Component
public class DatabaseJdbcFunctionCreator implements ApplicationListener<ApplicationReadyEvent> {


    @Autowired
    private JdbcCommandExecutor jdbcCommandExecutor;

    @Value("classpath:database/function/DbloggerFn.sql")
    Resource functionDbloggerFnResource;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        System.out.println("*********************************");
        System.out.println("Entering onApplicationEvent start");
        System.out.println("source description : "+ functionDbloggerFnResource.getDescription());
        InputStream inputStream = null;
        try {
            inputStream = functionDbloggerFnResource.getInputStream();
            String data = readFromInputStream(inputStream);
            System.out.println("data : "+data);
            jdbcCommandExecutor.SqlExecute(data);
            System.out.println("execute sql correct");
        } catch (IOException e) {
            System.out.println("error while execution function sentence");
            e.printStackTrace();
        }
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
