package com.drools.service;

import com.drools.vo.EventsVO;
import com.drools.vo.NotificationVO;
import org.springframework.web.bind.annotation.RequestBody;

public interface MailNotificationService {

     void sendNotification( NotificationVO notificationVO);
}
