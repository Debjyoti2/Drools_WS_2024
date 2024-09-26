package com.drools.vo;

import com.drools.enums.CustomerType;
import lombok.*;
import org.kie.api.definition.rule.All;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    private String custNO;
    private Integer age;
    private Integer amount;
    private CustomerType customerType;
    private Integer discountFromRule;

}
