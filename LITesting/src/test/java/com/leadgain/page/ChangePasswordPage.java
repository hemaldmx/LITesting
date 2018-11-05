package com.leadgain.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.leadgain.email.User;
import com.leadgain.utility.AbstractPage;

@Component
public class ChangePasswordPage extends AbstractPage {

   
    
    @Value("#{'${xpath.username}'}")
    private String xpathUsername;
    
    @Value("#{'${xpath.password}'}")
    private String xpathPassword;
    
    @Value("#{'${xpath.loginbtn}'}")
    private String xpathLoginBtn;
    
    @Value("#{'${xpath.changepassword}'}")
    private String xpathChangePassword;
    
    @Value("#{'${xpath.oldpassword}'}")
    private String xpathOldPassword;
    
    @Value("#{'${xpath.newpassword}'}")
    private String xpathNewPassword;
    
    @Value("#{'${xpath.confirmpassword}'}")
    private String xpathConfirmPassword;
    
    @Value("#{'${xpath.reset}'}")
    private String xpathResetBtn;
    
    @Value("#{'${xpath.cancel}'}")
    private String xpathCancelBtn;
    

   
    
    public void changePassword (String oldpassword, String newpassword, String confirmpassword) {
    // String url=webDriver.getCurrentUrl();
      assertAndClick(xpathChangePassword);
      assertAndSendKeys(xpathOldPassword, oldpassword);
      assertAndSendKeys(xpathNewPassword, newpassword);
      assertAndSendKeys(xpathConfirmPassword, confirmpassword);
      assertAndClick(xpathResetBtn);
    //  assertAndVerifyCurrentUrl(url);
      
    }
    
    public void changePasswordWithoutAssert (String oldpassword, String newpassword, String confirmpassword) {
     // String url=webDriver.getCurrentUrl();
      assertAndClick(xpathChangePassword);
      assertAndSendKeys(xpathOldPassword, oldpassword);
      assertAndSendKeys(xpathNewPassword, newpassword);
      assertAndSendKeys(xpathConfirmPassword, confirmpassword);
      assertAndClick(xpathResetBtn);
      
    }

    public boolean pageReady(String locator) {
      boolean pageReady = false;
      while (!pageReady) {
        System.out.println(pageReady);
        if(!isElementVisible(locator)) {
          pageReady=true;
        }
      }
      System.out.println(pageReady);
      return pageReady;
    }

}



