package com.app.spring.angular.course.SpringAngularCourse.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by jose de leon on 5/17/2021.
 */
@Data
@Embeddable
public class UserPreference {

    @Column(name = "receive_email_notification", nullable = true)
    private boolean receiveEmailNotification;

    @Column(name = "nick_name", nullable = true)
    private String nickname;

    @Column(name = "share_enable", nullable = true)
    private boolean shareEnable;

}
