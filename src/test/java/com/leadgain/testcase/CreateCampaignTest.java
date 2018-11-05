package com.leadgain.testcase;

import java.lang.reflect.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.leadgain.extent.ExtentTestManager;
import com.leadgain.listener.TestListener;
import com.leadgain.page.CampaignPageDelete;
import com.leadgain.page.ChangePasswordPage;
import com.leadgain.page.CreateCampaignPage;
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
public class CreateCampaignTest extends BaseClassTest {

      
    @Value("#{'${campaign.campaignnamevalue}'}")
    String campaignNameVal;
  
    @Value("#{'${campaign.trigger.page.url.value}'}")
    String triggerPageUrl;
    
    @Value("#{'${campaign.popup.content.url.value}'}")
    String popupContentUrl;
    
    @Value("#{'${campaign.existing.title.value}'}")
    String existingTitle;
    
    @Value("#{'${campaign.existing.roi.value}'}")
    String existingRoi;
    
    @Value("#{'${campaign.description.value}'}")
    String campaignDescription;
  
    @Value("#{'${correct.username}'}")
    String correctUsername;
    
    @Value("#{'${correct.password}'}")
    String correctPassword;
    
    @Autowired
    private CreateCampaignPage createCampaign;
    
    @Autowired
    private   CampaignPageDelete campaignPageDelete;

    @Test (priority = 1, groups= {"regression","smoke"}, description="Create Campaign.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Create Campaign")
    @Story("Create Campaign")
    public void createCampaign(Method method) throws InterruptedException {
      LOGGER.info(method.getName() + " test is starting.");
      createCampaign.gotoUrl(url);
      ExtentTestManager.getTest().setDescription("Login test and change password.");
      LOGGER.info("Trying to login LeadGain.");
      createCampaign.verifyLoginWithoutAssert(correctUsername, correctPassword);
      createCampaign.createCamapignMandatoryFields(campaignNameVal, triggerPageUrl, popupContentUrl, existingTitle);
      
      campaignPageDelete.verifyCampaignPageDelete();
    }
   
//    @Test (priority = 2, groups= {"regression","smoke"}, description="Create Campaign.")
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("Create Campaign")
//    @Story("Create Campaign")
//    public void createCamapignAdvManageMsg(Method method) throws InterruptedException {
//      LOGGER.info(method.getName() + " test is starting.");
//      createCampaign.gotoUrl(url);
//      ExtentTestManager.getTest().setDescription("Login test and change password.");
//      LOGGER.info("Trying to login LeadGain.");
//      createCampaign.verifyLoginWithoutAssert(correctUsername, correctPassword);
//      createCampaign.createCamapignAdvanceManageMsg(campaignNameVal, triggerPageUrl, popupContentUrl, existingTitle);
//     
//    }
    
//    @Test (priority = 1, groups= {"regression","smoke"}, description="Create Campaign.")
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("Create Campaign")
//    @Story("Create Campaign")
//    public void createCamapignAdvManageTeaser(Method method) throws InterruptedException {
//      LOGGER.info(method.getName() + " test is starting.");
//      createCampaign.gotoUrl(url);
//      ExtentTestManager.getTest().setDescription("Login test and change password.");
//      LOGGER.info("Trying to login LeadGain.");
//      createCampaign.verifyLoginWithoutAssert(correctUsername, correctPassword);
//      createCampaign.createCamapignManageTeaser(campaignNameVal, triggerPageUrl, popupContentUrl, existingTitle);
//     
//    }
//    
//    @Test (priority = 1, groups= {"regression","smoke"}, description="Create Campaign.")
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("Create Campaign")
//    @Story("Create Campaign")
//    public void createCamapignAdvManageQuestionChkbox (Method method) throws InterruptedException {
//      LOGGER.info(method.getName() + " test is starting.");
//      createCampaign.gotoUrl(url);
//      ExtentTestManager.getTest().setDescription("Login test and change password.");
//      LOGGER.info("Trying to login LeadGain.");
//      createCampaign.verifyLoginWithoutAssert(correctUsername, correctPassword);
//      createCampaign.createCamapignManageQuestionCheckbox (campaignNameVal, triggerPageUrl, popupContentUrl, existingTitle);
//     
//    }
//    
//    @Test (priority = 1, groups= {"regression","smoke"}, description="Create Campaign.")
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("Create Campaign")
//    @Story("Create Campaign")
//    public void createCamapignAdvManageQuestionRadioBtn (Method method) throws InterruptedException {
//      LOGGER.info(method.getName() + " test is starting.");
//      createCampaign.gotoUrl(url);
//      ExtentTestManager.getTest().setDescription("Login test and change password.");
//      LOGGER.info("Trying to login LeadGain.");
//      createCampaign.verifyLoginWithoutAssert(correctUsername, correctPassword);
//      createCampaign.createCamapignManageQuestionRadioBtn (campaignNameVal, triggerPageUrl, popupContentUrl, existingTitle);
//     
//    }

//    @Test (priority = 1, groups= {"regression","smoke"}, description="Create Campaign.")
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("Create Campaign")
//    @Story("Create Campaign")
//    public void createCamapignAdvAutomationSettings (Method method) throws InterruptedException {
//      LOGGER.info(method.getName() + " test is starting.");
//      createCampaign.gotoUrl(url);
//      ExtentTestManager.getTest().setDescription("Login test and change password.");
//      LOGGER.info("Trying to login LeadGain.");
//      createCampaign.verifyLoginWithoutAssert(correctUsername, correctPassword);
//      createCampaign.createCamapignAutomationSettings (campaignNameVal, triggerPageUrl, popupContentUrl, existingTitle);
//     
//    }


}