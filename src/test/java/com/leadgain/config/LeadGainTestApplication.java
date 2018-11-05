package com.leadgain.config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication
@ContextConfiguration(classes=LeadGainAppConfig.class)
@ComponentScan(
    basePackages = {"com.leadgain.*"})
public class LeadGainTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeadGainTestApplication.class, args);
    }
    
}