package com.leadgain.testcase;

import java.awt.AWTException;
import java.lang.reflect.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.leadgain.extent.ExtentTestManager;
import com.leadgain.listener.TestListener;
import com.leadgain.page.CampaignPage;
import com.leadgain.page.DemoPage;
import com.leadgain.page.ExitIntentPage;
import com.leadgain.page.LeadPage;
import com.leadgain.page.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Listeners({ TestListener.class })
@Epic("smoke Tests")
@Feature("demourl Tests")
public class DemoTest extends BaseClassTest {
  
  @Autowired
  private DemoPage demoPage;
  
  @Autowired
  private ExitIntentPage exitintentPage;
  
  @Autowired
  private LoginPage loginPage;
  
  @Autowired
  private CampaignPage campaignPage;
  
  @Autowired
  private LeadPage leadPage;
  
  @Value("#{'${demo.demoUrl}'}")
  private String demoUrl;
  
  @Value("#{'${demo.username}'}")
  private String demoUsername;
  
  @Value("#{'${demo.password}'}")
  private String demoPassword; 
  
  @Value("#{'${correct.emailfield.value}'}")
  String correctEmailFieldVal;
  
  @Value("#{'${select.campaign.name.for.prod}'}")
  private String campaignName;
  
  @Test (priority = 0, groups= {"smoke"}, description="Demo url verifying and click on button")
  @Severity(SeverityLevel.BLOCKER)
  @Description("Test Description: Demo url verification and click on learnmore button.")
  public void demoUrlTest (Method method) throws InterruptedException {
    LOGGER.info(method.getName() + " test is starting.");

    //ExtentReports Description
    ExtentTestManager.getTest().setDescription("Demo url verifying and click on button");


    //*************PAGE METHODS********************
//    LOGGER.info("Verify demo url");
//    demoPage.gotoUrl(demoUrl);
//    demoPage.verifyDemoIsRunning();
//    
//    
//    LOGGER.info("Verify demo link exists");
//    demoPage.gotoUrl(demoUrl);
//    demoPage.verifyDemoLinkExist();
//    

    LOGGER.info("Verify demo page header");
    demoPage.gotoUrl(demoUrl);
//    Thread.sleep(3000);
//    demoPage.verifyDemoPageTitle();
    
    LOGGER.info("Verifying Learn more button click.");
    Thread.sleep(3000);
    demoPage.verifyLearnmoreButtonClick();
}
  
  @Test (priority = 1, groups= {"smoke"}, description="Check ExitIntentPopup is displayed")
  @Severity(SeverityLevel.BLOCKER)
  @Description("Test Description: Dispaly ExitIntentPopup")
  public void checkExitIntentPopup() throws InterruptedException, AWTException {

    LOGGER.info("Verify Exit Intent Popup is display");
    exitintentPage.verifyExitPopupIsDisplayed();
  }
  
  @Test (priority = 2, groups= {"smoke"}, description="Verify download button click")
  @Severity(SeverityLevel.BLOCKER)
  @Description("Test Description:Check for Download button is clickable")
  public void checkDowonloadButtonClick() throws InterruptedException, AWTException {

    LOGGER.info("Verify download button click"); 
    exitintentPage.verifyDownloadButtonClick();
  }
  
  @Test (priority = 3, groups= {"smoke"}, description="Valid Submit lead Scenario with emailfield value")
  @Severity(SeverityLevel.BLOCKER)
  @Description("Test Description:submit lead value with correct emailfield")
  public void checkForValidLead() throws InterruptedException, AWTException {

    LOGGER.info("Trying to Submit Lead");
    exitintentPage.verifyAndSubmitEmail(correctEmailFieldVal);
  
  }
  @Test (priority = 4, groups= {"smoke"}, description="Verify scrollpage of the pdf")
  @Severity(SeverityLevel.BLOCKER)
  @Description("Test Description:Verify scrollpage of the pdf")
  public void checkForScrollPage() throws InterruptedException, AWTException {
    
    LOGGER.info("Verify scrollpage of the pdf");
    exitintentPage.veifyScrollPagePdf();
  
  }
  @Test (priority = 5, groups= {"smoke"}, description="login to application")
  @Severity(SeverityLevel.BLOCKER)
  @Description("Test Description: Login to application.")
  public void goToLogin() throws InterruptedException, AWTException{
    loginPage.gotoUrl(url);
    loginPage.verifyLogin(demoUsername, demoPassword);
  }
  
  @Test (priority = 6, groups= {"smoke"}, description="Click on campaign button and go to campaign list.")
  @Severity(SeverityLevel.BLOCKER)
  @Description("Test Description: click on campaign menu ,campaign list")
   public void goToCampaignsList() throws InterruptedException, AWTException{
     campaignPage.goToCampaignMenu();
     campaignPage.verifyCampaignPresent(campaignName);
  }

  @Test (priority = 7, groups= {"smoke"}, description="Click on campaign button and go to campaign list.")
  @Severity(SeverityLevel.BLOCKER)
  @Description("Test Description: click on campaign menu ,campaign list")
  public void goToLeadsPage()throws InterruptedException, AWTException{
    campaignPage.goToLeads(campaignName);
    
  }

  @Test (priority = 8, groups= {"smoke"}, description="Check submitted lead is present on leads page.")
  @Severity(SeverityLevel.BLOCKER)
  @Description("Test Description: ")
  public void checkLead() {
   // pageReady
    leadPage.verifySubmittedLead();
  }
  
  

}
