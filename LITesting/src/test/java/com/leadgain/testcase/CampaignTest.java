package com.leadgain.testcase;

import static org.testng.Assert.assertTrue;
import java.lang.reflect.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;
import com.leadgain.page.CampaignPage;
import com.leadgain.page.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


public class CampaignTest extends BaseClassTest {
  
  @Value("#{'${correct.username}'}")
  String correctUsername;
  
  @Value("#{'${correct.password}'}")
  String correctPassword;
  
  @Value("#{'${select.campaign.name}'}")
  private String campaignName;
  
  @Autowired
  private   LoginPage loginPage;
  
  @Autowired
  private   CampaignPage campaignPage;
  
  @Test (priority = 1, groups= {"regression","smoke"}, description="check campaign is present")
  @Severity(SeverityLevel.BLOCKER)
  @Description("Test Description: Check campaign is present by name")
  @Story("Check campaign is present")
  public void verifyCampaignIsPresent(Method method) throws InterruptedException {
    LOGGER.info(method.getName() + " test is starting.");
    loginPage.gotoUrl(url);
    loginPage.verifyLoginWithoutAssert(correctUsername, correctPassword);
    campaignPage.verifyCampaignPresent(campaignName);
   
  }
  
  @Test (priority = 2, groups= {"regression","smoke"}, description="Check campaign state is running")
  @Severity(SeverityLevel.MINOR)
  @Description("Test Description: Check campaign is running")
  @Story("Check campaign is running")
  public void verifyCampaignIsRunningAndChangeState(Method method) throws InterruptedException {
    LOGGER.info(method.getName() + " test is starting.");
    campaignPage.goToCampaignMenu();
    campaignPage.verifyCampaignState(campaignName, "Running");
    campaignPage.changeCampaignState(campaignName, "Running");
  }
  
  @Test (priority = 3, groups= {"regression","smoke"}, description="Check campaign state stopped")
  @Severity(SeverityLevel.MINOR)
  @Description("Test Description: Check campaign is stopped")
  @Story("Check campaign is stopped")
  public void verifyCampaignIsStopped(Method method) throws InterruptedException {
    LOGGER.info(method.getName() + " test is starting.");
    System.out.println("verifyCampaignIsStopped::");
    campaignPage.verifyCampaignState(campaignName, "Stopped");
    campaignPage.changeCampaignState(campaignName, "Stopped");

  }
}
