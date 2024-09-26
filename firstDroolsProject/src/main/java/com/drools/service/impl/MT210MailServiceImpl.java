package com.drools.service.impl;

import com.drools.service.NotificationEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("MT210MailServiceImpl")
@Slf4j
public class MT210MailServiceImpl implements NotificationEventService {


    @Override
    public void sendMail() {
        log.info("Sending MT210MailServiceImpl");
    }
}
