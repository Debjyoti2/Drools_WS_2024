package com.drools.controller;

import com.drools.service.MailNotificationService;
import com.drools.vo.EventsVO;
import com.drools.vo.NotificationRuleVO;
import com.drools.vo.NotificationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/mail")
public class MailNotificationController {

    @Autowired
    private MailNotificationService mailNotificationService;

    @PostMapping("/send-mail")
    public void sendNotification(@RequestBody NotificationVO notificationVO){
        mailNotificationService.sendNotification(notificationVO);

    }

}
