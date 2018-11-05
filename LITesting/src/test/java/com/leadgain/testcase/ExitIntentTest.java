package com.leadgain.testcase;

import java.awt.AWTException;
import java.lang.reflect.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.leadgain.extent.ExtentTestManager;
import com.leadgain.listener.TestListener;
import com.leadgain.page.DemoPage;
import com.leadgain.page.ExitIntentPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Listeners({ TestListener.class })
@Epic("Regression ,smoke Tests")
@Feature("ExitIntentPopup Tests")
public class ExitIntentTest extends BaseClassTest {

  @Autowired
  private ExitIntentPage exitintentPage;
  
  @Value("#{'${correct.emailfield.value}'}")
  String correctEmailFieldVal;
  
  @Test (priority = 0, groups= {"regression","smoke"}, description="Valid Submit lead Scenario with emailfield value.")
  @Severity(SeverityLevel.CRITICAL)
  @Description("Test Description: submit lead value with correct emailfield.")
  @Story("fill and submit correct emailfieldval test")
  public void validLeadTest_ValidEmailField (Method method) throws InterruptedException, AWTException {
    LOGGER.info(method.getName() + " test is starting.");
    ExtentTestManager.getTest().setDescription("ExitIntent popup verification Test and Submit lead");
    
    LOGGER.info("Verify Exit Intent Popup is display");
    exitintentPage.verifyExitPopupIsDisplayed();
 
 /* LOGGER.info("Verify Exitintent popup pdf title ");
  exitintentpage.verifyExitIntentPopupTitle();*/
    
   LOGGER.info("Verify download button click"); 
   exitintentPage.verifyDownloadButtonClick();
  
   LOGGER.info("Trying to Submit Lead");
   exitintentPage.verifyAndSubmitEmail(correctEmailFieldVal);
   
   LOGGER.info("Verify scrollpage of the pdf");
   exitintentPage.veifyScrollPagePdf();
  
   }
}
  
