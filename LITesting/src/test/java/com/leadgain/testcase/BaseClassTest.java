package com.leadgain.testcase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.leadgain.config.LeadGainTestApplication;

@SpringBootTest(classes = LeadGainTestApplication.class, value="leadgain.properties", 
                    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseClassTest extends AbstractTestNGSpringContextTests {
  
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseClassTest.class);
  
    @Autowired
    protected WebDriver webDriver;
  
    @Value("#{'${webdriver.wait}'}")
    private Integer webdriverWait;
    
    public WebDriverWait wait;
    
    @Value("#{'${application.url}'}")
    protected String url;


    @BeforeClass (description = "Class Level Setup!")
    public void setup () {
        LOGGER.info("Test is starting!");
        wait = new WebDriverWait(webDriver,webdriverWait);
        webDriver.manage().window().maximize();
    }

    @AfterClass(description = "Class Level Teardown!")
    public void teardown () {
        LOGGER.info("Test is ending!");
        webDriver.quit();
    }

}
