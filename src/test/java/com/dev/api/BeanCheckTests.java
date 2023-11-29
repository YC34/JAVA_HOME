package com.dev.api;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;


/**
 *
 * 등록된 bean들의 체크해봄.
 *
 * **/
@SpringBootTest
public class BeanCheckTests {

    @Autowired
    private ApplicationContext applicationContext;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    void BeanCheck(){
        String[] beanNames=applicationContext.getBeanDefinitionNames();

        for(String beanName : beanNames){
            log.info("빈의 이름은 : {} ",beanName);
        }


    }


}
