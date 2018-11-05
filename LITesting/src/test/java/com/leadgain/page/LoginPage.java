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
public class LoginPage extends AbstractPage {

    @Autowired
    private User user;
  
    @Value("#{'${title.loginPage}'}")
    private String PAGE_TITLE;
    
    @Value("#{'${xpath.title.loginPage}'}")
    private String xpathPageTitle;
    
    @Value("#{'${login.failuremsg}'}")
    private String LOGIN_FAILURE_MSG;
    
    @Value("#{'${xpath.forgotpasswordbtn}'}")
    private String xpathForgotPasswordbtn;
    
    @Value("#{'${xpath.footer.msg}'}")
    private String xpathFooterMsg;
    
    @Value("#{'${footer.msg}'}")
    private String FOOTER_MSG;
    
    @Value("#{'${xpath.login.failuremsg}'}")
    private String xpathLoginFailureMsg;
    
    @Value("#{'${xpath.username}'}")
    private String xpathUsername;
    
    @Value("#{'${xpath.password}'}")
    private String xpathPassword;
    
    @Value("#{'${xpath.loginbtn}'}")
    private String xpathLoginBtn;
    
    @Value("#{'${empty.username.msg}'}")
    private String EMPTY_USERNAME_MSG;
    
    @Value("#{'${xpath.empty.username.msg}'}")
    private String xpathEmptyUsernameMsg;
    
    @Value("#{'${empty.password.msg}'}")
    private String EMPTY_PASSWORD_MSG;
    
    @Value("#{'${xpath.empty.username.msg}'}")
    private String xpathEmptyPasswordMsg;
    
    @Value("#{'${xpath.logoutbtn}'}")
    private String xpathLogoutBtn;

    
    public void verifyLoginPageHeader() {
        waitForElement(xpathPageTitle);
        WebElement headerEle = webDriver.findElement(By.xpath(xpathPageTitle));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, PAGE_TITLE,
                "Actual heading '" + actualHeading + "' should be same as expected '" + PAGE_TITLE + "'.");
    }
    
    public void verifyLoginPageFooter() {
        waitForElement(xpathFooterMsg);
        WebElement headerEle = webDriver.findElement(By.xpath(xpathFooterMsg));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, FOOTER_MSG,
              "Actual heading '" + actualHeading + "' should be same as expected '" + FOOTER_MSG + "'.");
  }

    public void verifyLogin(String username, String password) {
        String url=webDriver.getCurrentUrl();
        assertAndSendKeys(xpathUsername, username);
        assertAndSendKeys(xpathPassword, password);
        assertAndClick(xpathLoginBtn);
        assertAndVerifyCurrentUrlNotEqual(url);
                       
    }
    
    public void verifyLoginWithoutAssert(String username, String password) {
     // String url=webDriver.getCurrentUrl();
      assertAndSendKeys(xpathUsername, username);
      assertAndSendKeys(xpathPassword, password);
      assertAndClick(xpathLoginBtn);
                          
  }

    public void verifyLoginWithInvalidUser(String username, String password) {
        assertAndSendKeys(xpathUsername, username);
        assertAndSendKeys(xpathPassword, password);
        assertAndClick(xpathLoginBtn);
        waitForElementVisible(xpathLoginFailureMsg);
        String actualMsg = webDriver.findElement(By.xpath(xpathLoginFailureMsg)).getText().trim();
        assertTrue(actualMsg.contains(LOGIN_FAILURE_MSG),
                "Actual '" + actualMsg + "' should be same as expected '" + LOGIN_FAILURE_MSG + "'.");
    }
    
    public void verifyLoginWithEmptyUser(String username, String password) {
      assertAndSendKeys(xpathUsername, username);
      assertAndSendKeys(xpathPassword, password);
      assertAndClick(xpathLoginBtn);
      waitForElementVisible(xpathEmptyUsernameMsg);
      waitForElementVisible(xpathEmptyPasswordMsg);
      String actualMsg = webDriver.findElement(By.xpath(xpathEmptyUsernameMsg)).getText().trim();
      assertTrue(actualMsg.contains(EMPTY_USERNAME_MSG),
              "Actual '" + actualMsg + "' should be same as expected '" + EMPTY_USERNAME_MSG + "'.");
      actualMsg = webDriver.findElement(By.xpath(xpathEmptyPasswordMsg)).getText().trim();
      assertTrue(actualMsg.contains(EMPTY_PASSWORD_MSG),
          "Actual '" + actualMsg + "' should be same as expected '" + EMPTY_PASSWORD_MSG + "'.");
  }
    
    public void verifyLogout() {
      String url=webDriver.getCurrentUrl();
      assertAndClick(xpathLogoutBtn);
      assertAndVerifyCurrentUrlNotEqual(url);
    }


}
