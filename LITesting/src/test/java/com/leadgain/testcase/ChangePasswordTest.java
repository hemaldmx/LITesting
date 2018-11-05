package com.leadgain.testcase;


import java.lang.reflect.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.gargoylesoftware.htmlunit.AbstractPage;
import com.leadgain.extent.ExtentTestManager;
import com.leadgain.listener.TestListener;
import com.leadgain.page.ChangePasswordPage;
import com.leadgain.page.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login Tests")
public class ChangePasswordTest extends BaseClassTest {

       
    @Value("#{'${correct.username}'}")
    String correctUsername;
    
    @Value("#{'${correct.password}'}")
    String correctPassword;
    
    @Value("#{'${change.password}'}")
    String changePassword;
    
    @Value("#{'${xpath.loader}'}")
    String xpathLoader;
    
    @Autowired
    private LoginPage loginPage;
    
    @Autowired
    private ChangePasswordPage changepasswordpage;
    
    @Test (priority = 1, groups= {"regression","smoke"}, description="Login test and change password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test and change password.")
    @Story("Login test and change password")
    public void changePassword (Method method) throws InterruptedException {
        LOGGER.info(method.getName() + " test is starting.");
        loginPage.gotoUrl(url);
        ExtentTestManager.getTest().setDescription("Login test and change password.");
        LOGGER.info("Trying to login LeadGain.");
        loginPage.verifyLoginWithoutAssert(correctUsername, correctPassword);
        changepasswordpage.pageReady(xpathLoader);
        changepasswordpage.changePassword(correctPassword, changePassword, changePassword);
        loginPage.verifyLogout();
        loginPage.verifyLoginWithoutAssert(correctUsername, changePassword);
        changepasswordpage.pageReady(xpathLoader);
      changepasswordpage.changePasswordWithoutAssert(changePassword, correctPassword, correctPassword);
      loginPage.verifyLogout();
    }

}


