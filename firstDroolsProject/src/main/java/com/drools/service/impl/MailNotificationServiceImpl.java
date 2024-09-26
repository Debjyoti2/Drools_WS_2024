package com.drools.service.impl;

import com.drools.rules.NotificationServiceRule;
import com.drools.service.MailNotificationService;
import com.drools.service.NotificationEventService;
import com.drools.vo.NotificationRuleVO;
import com.drools.vo.NotificationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailNotificationServiceImpl implements MailNotificationService {

    @Autowired
    private NotificationServiceRule notificationServiceRule;

    @Autowired
    ApplicationContext applicationContext;
    @Override
    public void sendNotification(NotificationVO notificationVO) {
        System.out.println("notificationVO is {} +  notificationVO " + notificationVO.toString() );
        NotificationRuleVO notificationRuleVO =notificationServiceRule.findNotificationRule(notificationVO);
        log.info("Bean Name Is :: {} ", notificationRuleVO.getBeanName());

        //Programmatically Loading Bean
        NotificationEventService notificationEventService = (NotificationEventService) applicationContext.getBean( notificationRuleVO.getBeanName());
        notificationEventService.sendMail();
    }
}
