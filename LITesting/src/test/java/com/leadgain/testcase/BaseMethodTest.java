package com.leadgain.testcase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseMethodTest {

      private static final Logger LOGGER = LoggerFactory.getLogger(BaseClassTest.class);
      
      @Autowired
      private WebDriver webDriver;
    
      @Value("#{'${webdriver.wait}'}")
      private Integer webdriverWait;

      @BeforeMethod(alwaysRun = true)
      public void setUp() {
        LOGGER.info("*** Setup ***");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
      }

    
      @AfterMethod(alwaysRun = true)
      public void teardown() {
          LOGGER.info("*** Teardown ***");
          if (webDriver != null)
            webDriver.quit();
      }

    /*public FirefoxProfile createFirefoxProfile() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.dir", "C:\\Users\\lenovo\\Downloads");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/pdf,application/vnd.ms-excel,application/octet-stream");
        firefoxProfile.setPreference("pdfjs.disabled", true);
        return firefoxProfile;
    }*/

}
