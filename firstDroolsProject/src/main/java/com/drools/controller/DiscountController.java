package com.drools.controller;

import com.drools.service.DiscountService;
import com.drools.vo.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@Slf4j
@RequestMapping("/order")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @PostMapping(value = "/discount",produces = "application/json")
    private OrderRequest getDiscountForCustomer(@RequestBody OrderRequest orderRequest) throws BadRequestException {
     return discountService.getDiscountForCustomer(orderRequest);
    }


}
