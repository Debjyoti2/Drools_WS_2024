package com.drools.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parent")
public class TestController {

     @GetMapping(value = "/testme",produces = "application/json")
     public String testMethod(){
         return "Hello I am running";
     }


}
