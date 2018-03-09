package com.test.spring.support.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TestConfiguration {
        public TestConfiguration(){
            System.out.println("spring����������ʼ��������");
        }

    //@Beanע��ע��bean,ͬʱ����ָ����ʼ�������ٷ���
    //@Bean(name="testNean",initMethod="start",destroyMethod="cleanUp")
    @Bean
    @Scope("prototype")
    public TestBean testBean() {
        return new TestBean();
    }
}