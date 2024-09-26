package com.drools.service.impl;

import com.drools.service.NotificationEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("IssuerPaymentsMailServiceImpl")
@Slf4j
public class IssuerPaymentsMailServiceImpl implements NotificationEventService {
    @Override
    public void sendMail() {
       log.info("Sending IssuerPaymentsMailServiceImpl");
    }
}
