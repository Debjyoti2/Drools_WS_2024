package com.drools.config;

import lombok.extern.slf4j.Slf4j;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

import java.util.stream.Stream;

@Configuration
@Slf4j
public class DroolsConfig {

    private static final String CUSTOMER_DISCOUNT_RULE="rules/customer-discount.drl";
    private static final KieServices kieservices = KieServices.Factory.get();


 @Autowired
 ResourceLoader resourceLoader;

 @Bean
 @Primary
 public KieContainer kieContainer(){

     KieFileSystem kieFileSystem = kieservices.newKieFileSystem();
     Resource[] drlResources;
     Resource[] xlsxResources;

     try{
         drlResources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
                 .getResources("classpath:rules/*.drl");
         Stream.of(drlResources)
                 .map(e->ResourceFactory.newClassPathResource("rules/"+e.getFilename(),getClass().getClassLoader()))
                 .forEach(e->kieFileSystem.write(e));

         xlsxResources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
                 .getResources("classpath:rules/*.xlsx");
         Stream.of(xlsxResources)
                 .map(e->ResourceFactory.newClassPathResource("rules/"+e.getFilename(),getClass().getClassLoader()))
                 .forEach(e->kieFileSystem.write(e));


         KieBuilder kieBuilder = kieservices.newKieBuilder(kieFileSystem);
         kieBuilder.buildAll();
         KieModule kieModule = kieBuilder.getKieModule();
         return kieservices.newKieContainer(kieModule.getReleaseId());

     }catch(Exception e){
         log.error("Error while loading drools rules file ",e);
         throw new RuntimeException("Error while loading drools rules file");
     }
 }









}



