package com.example.springbootexperiment06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
public class SpringbootExperiment06Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootExperiment06Application.class, args);
    }
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(){
        return  new MethodValidationPostProcessor();
    }

}
