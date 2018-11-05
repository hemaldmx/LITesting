package com.leadgain.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.leadgain.utility.AbstractPage;

@Component
public class DemoPage extends AbstractPage {
    
  @Value("#{'${demo.demoUrl}'}")
  private String demoUrl;
  
  @Value("#{'${xpath.learnmorebtn}'}")
  private String xpathLearnMoreBtn;
  
  @Value("#{'${title.demoPage}'}")
  private String demoPageTitle;
  
  @Value("#{'${xpath.title.demoPage}'}")
  private String xpathDemoPageTitle;
 

    public void verifyDemoPageTitle() {
      waitForElement(xpathDemoPageTitle);
      WebElement headerEle = webDriver.findElement(By.xpath(xpathDemoPageTitle));
      String actualHeading = headerEle.getText();
      assertEquals(actualHeading, demoPageTitle,
          "Actual heading '" + actualHeading + "' should be same as expected '" + demoPageTitle + "'.");

    }
    public void verifyLearnmoreButtonClick()
    {
      assertAndClick(xpathLearnMoreBtn, 0);

    }
    /*public void verifyDemoIsRunning() {
    webDriver.get(demoUrl);
    
   }
   
   public void verifyDemoLinkExist() {
     String demoUrl=webDriver.getCurrentUrl();
     assertAndVerifyCurrentUrl(demoUrl);
   }*/
}
