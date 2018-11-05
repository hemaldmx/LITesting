package com.leadgain.page;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.leadgain.utility.AbstractPage;

@Component
public class CampaignPage extends AbstractPage{

  @Value("#{'${xpath.campaignbtn}'}")
  private String xpathCampaignBtn;
  
  @Value("#{'${xpath.table.rows}'}")
  private String xpathTableRows;
  
  @Value("#{'${xpath.lead.table.rows}'}")
  private String xpathLeadTableRows;
 
  @Value("#{'${xpath.lead.submitted}'}")
  private String xpathLeadSubmitted;
  
  @Value("#{'${correct.emailfield.value}'}")
  String correctEmailFieldVal;
 
  @Value("#{'${xpath.loader.stopcamapign}'}")
  String xpathLoaderPauseCampaign;
  
  @Value("#{'${xpath.loader.startcamapign}'}")
  String xpathLoaderStartCampaign;
  
  public void verifyCampaignPresent(String campaignName){
    assertAndClick(xpathCampaignBtn);
    WebElement element=findWebElement(xpathTableRows, campaignName);
    assertNotNull(element, "Campaign with name : "+campaignName+ " not present ");
  }
  
 public void goToLeads(String campaignName){
    WebElement element=findWebElement(xpathTableRows, campaignName);
    List<WebElement> listele = element.findElements(By.className("ant-btn"));
    listele.get(2).click();
    System.out.println(listele.get(2).getText());
    }

   public void verifyCampaignState(String campaignName, String state){
    //check state runnig or stop
     assertAndClick(xpathCampaignBtn);
     WebElement element=findWebElement(xpathTableRows, campaignName);
     boolean status=false;
     if(state.equalsIgnoreCase("Running")) {
       status = element.getText().contains("Running");
     }else if(state.equalsIgnoreCase("Stopped")) {
       status = element.getText().contains("Stopped");
     }else if(state.equalsIgnoreCase("Created")) {
       status = element.getText().contains("Created");
     }
     assertTrue(status, "Campaign state "+state+" not found ");
 
   }
   
   public void goToCampaignMenu() {
     // TODO Auto-generated method stub
     assertAndClick(xpathCampaignBtn);
   }
   
   public void changeCampaignState(String campaignName, String state) {
     verifyCampaignState(campaignName, state);
     WebElement element=findWebElement(xpathTableRows, campaignName);
    // pageReady(xpathLoaderPauseCampaign);
     if(state.equalsIgnoreCase("Running")) {
      element.findElement(By.className("anticon-pause-circle")).click();
      
     }else if(state.equalsIgnoreCase("Stopped")) {
       element.findElement(By.className("anticon-play-circle")).click();
       
     }
     waitForElementInVisible(xpathLoaderStartCampaign);
     /*WebElement element2=findWebElement(xpathTableRows, campaignName);
     element2.findElement(By.xpath("/div[@title='Stopped']")).isDisplayed();
     //pageReady(xpathLoaderStartCampaign);
     element.findElement(By.className("anticon-play-circle-o")).click();
    //  List<WebElement> pauseElement=element.findElements(By.className("anticon-pause-circle"));
 //   pauseElement.get(0).click();
*/    
   }
   
  
//  gotodashboard
//  gotoEdit 
//  script 
//  jobs
  
  }

