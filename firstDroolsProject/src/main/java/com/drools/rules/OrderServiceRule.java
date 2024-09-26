package com.drools.rules;

import com.drools.vo.OrderDiscount;
import com.drools.vo.OrderRequest;
import org.apache.coyote.BadRequestException;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceRule {

    @Autowired
    private KieContainer kieContainer;

    public OrderRequest getDiscountForOrder(OrderRequest orderRequest) throws BadRequestException {

        KieSession kieSession = kieContainer.newKieSession();

        OrderDiscount orderDiscount = new OrderDiscount();

        kieSession.setGlobal("orderDiscount", orderDiscount);
        kieSession.insert(orderRequest);
        int c = kieSession.fireAllRules();
        if(c==0){
            throw new BadRequestException("We are unable to find out any rules as per given input");
        }

        OrderRequest orderRequestRule = OrderRequest.builder()
                .custNO(orderRequest.getCustNO())
                .age(orderRequest.getAge())
                .amount(orderRequest.getAmount())
                .customerType(orderRequest.getCustomerType())
                .discountFromRule(orderDiscount.getDiscount())
                .build();

        return orderRequestRule;

    }

}
