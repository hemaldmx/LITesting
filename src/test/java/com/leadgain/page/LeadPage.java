package com.leadgain.page;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.testng.Assert.assertNotNull;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.leadgain.utility.AbstractPage;

@Component
public class LeadPage extends AbstractPage{

  @Value("#{'${xpath.lead.table.rows}'}")
  private String xpathLeadTableRows;
 
  @Value("#{'${xpath.lead.submitted}'}")
  private String xpathLeadSubmitted;
  
  @Value("#{'${correct.emailfield.value}'}")
  String correctEmailFieldVal;
  
  @Value("#{'${xpath.loader.leadpage}'}")
  String xpathLoaderLeadPage;
  
  public void verifySubmittedLead() {
    boolean staleElement = true; 
    while(staleElement){
      try {
     waitForElementInVisible(xpathLoaderLeadPage);
     WebElement element =findWebElement(xpathLeadTableRows, correctEmailFieldVal);
     System.out.println("lead present: "+element.getText().contains(correctEmailFieldVal));
     System.out.println(element.getText());
     assertNotNull(element, "Submit lead "+correctEmailFieldVal+" not captured");
     staleElement = false;
      }catch(StaleElementReferenceException e) {
        staleElement = true;
      }
    }
   }
  
}
