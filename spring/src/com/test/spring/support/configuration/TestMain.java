package com.test.spring.support.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
        //ªÒ»°bean
        TestBean tb = (TestBean) context.getBean("testBean");
        tb.sayHello();
        tb.start();
    }
}