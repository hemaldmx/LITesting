package com.leadgain.testcase;

import java.lang.reflect.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import com.leadgain.page.CampaignPage;
import com.leadgain.page.LeadPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LeadTest extends BaseClassTest{
  @Autowired
  private   LeadPage leadPage;
  
  @Test (priority = 1, groups= {"regression","smoke"}, description="Check Lead flow")
  @Severity(SeverityLevel.BLOCKER)
  @Description("Test Description: Check Lead flow")
  @Story("Check Submitted lead in leads page in campaign ")
  public void verifyLeadFlow(Method method) throws InterruptedException {
    LOGGER.info(method.getName() + " test is starting.");
    leadPage.verifySubmittedLead();
    
  }
}
