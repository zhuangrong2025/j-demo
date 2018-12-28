package com.annotation_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by user on 2018/12/28.
 */

// @Configuration可理解为用spring的时候xml里面的<beans>标签
// @Bean可理解为用spring的时候xml里面的<bean>标签

@Configuration
public class ConfigA {
    @Bean(name="Toyota")
    public Car getToyota(){
        return new Toyota();
    }

}
