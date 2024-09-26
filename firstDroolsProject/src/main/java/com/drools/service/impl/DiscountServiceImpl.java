package com.drools.service.impl;

import com.drools.rules.OrderServiceRule;
import com.drools.service.DiscountService;
import com.drools.vo.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private OrderServiceRule orderServiceRule;

    @Override
    public OrderRequest getDiscountForCustomer(OrderRequest orderRequest) throws BadRequestException {
        try{
            return orderServiceRule.getDiscountForOrder(orderRequest);
        }
        catch(Exception e){
            log.error("Error while getting discount for customer {} " , orderRequest);
            throw new BadRequestException("Error while getting discount for customer");
        }

    }
}
