package com.drools.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailVO implements EventsVO{

    private String mailId;
    private String notificationType;
    private String sender;

}
