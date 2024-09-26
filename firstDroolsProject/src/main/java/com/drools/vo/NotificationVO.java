package com.drools.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationVO implements EventsVO{

    private String notificationId;
    private String notificationType;
    private String sender;

}
