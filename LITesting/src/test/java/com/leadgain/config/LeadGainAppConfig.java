package com.leadgain.config;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;

@Configuration
@TestPropertySource(value= {"classpath:application.properties","classpath:leadgain.properties"})
@PropertySource(value= {"classpath:application.properties","classpath:leadgain.properties"})
@ComponentScan
@EnableAutoConfiguration
public class LeadGainAppConfig {
  
	@Value(value = "${browser.type}") 
	public String browserType;
	
    @Bean(name = "driverFactory")
    public DriverFactory driverFactory() {
    	DriverFactory driverFactory = new DriverFactory(browserType);
        return driverFactory;
    }
 
	@Autowired
    private DriverFactory driverFactory;
	
    @Bean(name="webDriver")
    public WebDriver webDriver() throws Exception {
		return driverFactory.getObject();
	}
    
    public void destroy() throws Exception{
      webDriver().quit();
    }
}