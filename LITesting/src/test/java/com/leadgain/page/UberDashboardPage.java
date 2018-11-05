package com.leadgain.page;

import org.openqa.selenium.StaleElementReferenceException;
import org.springframework.beans.factory.annotation.Value;
import com.leadgain.utility.AbstractPage;

public class UberDashboardPage extends AbstractPage{

  @Value("#{'${xpath.username}'}")
  private String xpathUsername;
  
  @Value("#{'${xpath.password}'}")
  private String xpathPassword;
  
  @Value("#{'${xpath.loginbtn}'}")
  private String xpathLoginBtn;
  
  @Value("#{'${xpath.dashboard.button}'}")
  private String xpathDashboardButton;
  
  public void verifyLoginWithoutAssert(String username, String password) {
    // String url=webDriver.getCurrentUrl();
     assertAndSendKeys(xpathUsername, username);
     assertAndSendKeys(xpathPassword, password);
     assertAndClick(xpathLoginBtn);
 }
  
  public void uberDashboard () throws InterruptedException {
    boolean staleElement = true; 
    while(staleElement){
      try {
      assertAndClick(xpathDashboardButton, 0);
     
      }catch(StaleElementReferenceException e) {
        staleElement = true;
      }
    }
    }
}


