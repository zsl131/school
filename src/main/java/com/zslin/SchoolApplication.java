package com.zslin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zsl-pc on 2016/7/20.
 */
//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SchoolApplication {
    public static void main(String [] args) {
//        SpringApplication app = new SpringApplication(SchoolApplication.class);
//        app.addListeners(new ApplicationStart());
//        app.run(args);
        SpringApplication.run(SchoolApplication.class, args);
    }
}
