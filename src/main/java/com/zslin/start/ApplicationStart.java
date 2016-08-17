package com.zslin.start;

import com.zslin.tools.MySystemConfigTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by zsl-pc on 2016/8/7.
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class ApplicationStart implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {

    @Value("${wsdl}")
    private String wsdl;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        System.out.println("==onBoot:"+wsdl);
    }

    @Override
    public void run(String... strings) throws Exception {
//        System.out.println("==onBoot run :"+wsdl);
        MySystemConfigTools.getInstance().setWsdl(wsdl);
    }
}
