package com.drools.rules;

import com.drools.vo.NotificationRuleVO;
import com.drools.vo.NotificationVO;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
public class NotificationServiceRule {

    @Autowired
    private KieContainer kieContainer;

    public NotificationRuleVO findNotificationRule(NotificationVO notificationVO){

        KieSession kieSession = kieContainer.newKieSession();
        NotificationRuleVO notificationRuleVO = NotificationRuleVO.builder()
                .category(notificationVO.getNotificationType())
                .region("EMEA")
                .build();
        kieSession.insert(notificationRuleVO);
        int c = kieSession.fireAllRules();
        if(c==0){
            log.error("No valid rule present ");
        }
        return notificationRuleVO;

    }


}
