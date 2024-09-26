package com.drools.service;

import com.drools.vo.OrderRequest;
import org.apache.coyote.BadRequestException;

public interface DiscountService {

    OrderRequest getDiscountForCustomer(OrderRequest orderRequest) throws BadRequestException;

}
