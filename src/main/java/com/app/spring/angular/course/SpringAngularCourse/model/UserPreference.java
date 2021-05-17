package com.app.spring.angular.course.SpringAngularCourse.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by jose de leon on 5/17/2021.
 */
@Embeddable
public class UserPreference {

    @Column(name = "receive_email_notification")
    private boolean reciveEmailNotification;

    @Column(name = "nick_name")
    private String nickname;

    @Column(name = "share_enable")
    private boolean shareEnable;

}
