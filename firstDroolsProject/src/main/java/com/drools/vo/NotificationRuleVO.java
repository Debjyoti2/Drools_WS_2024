package com.drools.vo;

import lombok.*;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRuleVO {


    private String category;
    private String region;
    private String beanName;
    private String outTopicName;
}
