package com.leadgain.testcase;

import java.lang.reflect.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;
import com.leadgain.page.CampaignPageDashboard;
import com.leadgain.page.CampaignPageEdit;
import com.leadgain.page.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


public class CampaignEditTest extends BaseClassTest {
  
  @Value("#{'${correct.username}'}")
  String correctUsername;
  
  @Value("#{'${correct.password}'}")
  String correctPassword;
  
  @Autowired
  private   LoginPage loginPage;
  
  @Autowired
  private   CampaignPageEdit campaignPageEdit;
  
  @Test (priority = 1, groups= {"regression","smoke"}, description="Check Lead flow")
  @Severity(SeverityLevel.BLOCKER)
  @Description("Test Description: Check campaign is present and click on leads button of that campaign")
  @Story("Check campaign is present")
  public void verifyCampaignIsPresent(Method method) throws InterruptedException {
    LOGGER.info(method.getName() + " test is starting.");
    campaignPageEdit.gotoUrl(url);
    loginPage.verifyLoginWithoutAssert(correctUsername, correctPassword);
    campaignPageEdit.verifyCampaignPageEdit();
    Thread.sleep(6000);
 //   campaignPage.verifySubmittedLead();
  }
}
