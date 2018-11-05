package com.leadgain.testcase;

import java.lang.reflect.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;
import com.leadgain.extent.ExtentTestManager;
import com.leadgain.page.UberDashboardPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import com.leadgain.listener.TestListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;


@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login Tests")

public class UberDashboardTest extends BaseClassTest {
@Value("#{'${correct.username}'}")
String correctUsername;

@Value("#{'${correct.password}'}")
String correctPassword;

@Autowired
private UberDashboardPage uberDashboardPage;

@Test (priority = 1, groups= {"regression","smoke"}, description="Create Campaign.")
@Severity(SeverityLevel.BLOCKER)
@Description("Create Campaign")
@Story("Create Campaign")
public void uberDashboardCheckUrl(Method method) throws InterruptedException {
  LOGGER.info(method.getName() + " test is starting.");
  uberDashboardPage.gotoUrl(url);
  ExtentTestManager.getTest().setDescription("Login test and change password.");
  LOGGER.info("Trying to login LeadGain.");
  uberDashboardPage.verifyLoginWithoutAssert(correctUsername, correctPassword);
  uberDashboardPage.uberDashboard();
 
}



}
