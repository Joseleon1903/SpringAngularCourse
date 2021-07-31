package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by jose de leon on 7/31/2021.
 */
@Data
@Entity(name = "AppLog")
@Table(name =  "db_application_log")
public class DbAplicactionLog {

    @Id
    @SequenceGenerator(
            name = "db_application_log_sequence",
            sequenceName ="db_application_log_sequence" ,
            allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "db_application_log_sequence")
    @Column(name = "log_id" , updatable = false)
    private Long logId;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "class_name")
    private String className;

    @Column(name = "reference")
    private String reference;


}
