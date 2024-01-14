package com.example.demo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class BeanConfig {
//    @Bean
//    public Doctor doctor(){
//        return new Doctor();
//    }
}
