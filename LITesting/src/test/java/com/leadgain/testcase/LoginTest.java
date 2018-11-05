package com.leadgain.testcase;

import java.lang.reflect.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.leadgain.extent.ExtentTestManager;
import com.leadgain.listener.TestListener;
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
public class LoginTest extends BaseClassTest {

    @Value("#{'${wrong.username}'}")
    String wrongUsername;
    
    @Value("#{'${wrong.password}'}")
    String wrongPassword;
    
    @Value("#{'${correct.username}'}")
    String correctUsername;
    
    @Value("#{'${correct.password}'}")
    String correctPassword;
    
    @Autowired
    private LoginPage loginPage;

    @Test (priority = 1, groups= {"regression","smoke"}, description="Invalid Login Scenario with wrong username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with wrong username and wrong password.")
    @Story("Invalid username and password login test")
    public void invalidLoginTest_InvalidUserNameInvalidPassword (Method method) throws InterruptedException {
        LOGGER.info(method.getName() + " test is starting.");

        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("Invalid Login Scenario with wrong username and password.");


        //*************PAGE METHODS********************
        LOGGER.info("Verify login page title");
        loginPage.gotoUrl(url);
        loginPage.verifyLoginPageHeader();
        
        
        LOGGER.info("Verify login page footer");
        loginPage.gotoUrl(url);
        loginPage.verifyLoginPageFooter();
        
        //Login to application
        LOGGER.info("Trying to login LeadGain.");
        loginPage.verifyLogin(correctUsername, correctPassword);

        //*************ASSERTIONS***********************
//        Thread.sleep(500);
        LOGGER.info("Verifying LeadGain login.");
        loginPage.gotoUrl(url);
        loginPage.verifyLoginWithInvalidUser(wrongUsername, wrongPassword);
    }

    @Test (priority = 2, description="Invalid Login Scenario with empty username and password.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login test with empty username and empty password.")
    @Story("Empty username and password login test")
    public void invalidLoginTest_EmptyUserEmptyPassword () throws InterruptedException {
        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("Invalid Login Scenario with empty username and password.");

        loginPage.gotoUrl(url);
        
        Thread.sleep(500);
        loginPage.verifyLoginWithEmptyUser("","");
    }
        
    @Test (priority = 3, groups= {"regression","smoke"}, description="Valid Login Scenario with correct username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with correct username and password.")
    @Story("Invalid username and password login test")
    public void validLoginTest_ValidUserNameValidPassword (Method method) throws InterruptedException {
        LOGGER.info(method.getName() + " test is starting.");

        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("Valid Login Scenario with correct username and password.");

//        LOGGER.info("Verify login page title");
//        loginPage.gotoUrl(url);
//        loginPage.verifyLoginPageHeader();
//        
//        
//        LOGGER.info("Verify login page footer");
//        loginPage.gotoUrl(url);
//        loginPage.verifyLoginPageFooter();
        
        LOGGER.info("Trying to login LeadGain.");
        loginPage.verifyLogin(correctUsername, correctPassword);
    }
    
    
    @Test (priority = 4, groups= {"regression","smoke"}, description="Check Logout Button.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Check Logout Button.")
    @Story("Check Logout Button")
    public void checkLogout (Method method) throws InterruptedException {
        LOGGER.info(method.getName() + " test is starting.");

            
        LOGGER.info("Check Logout Button.");
        loginPage.verifyLogin(correctUsername, correctPassword);
        loginPage.verifyLogout();
    }
   

}