package com.leadgain.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.leadgain.utility.AbstractPage;

@Component
public class CampaignPageEdit extends AbstractPage{

  @Value("#{'${xpath.campaignbtn}'}")
  private String xpathCampaignBtn;
  
  @Value("#{'${xpath.table.rows}'}")
  private String xpathTableRows;
  
  @Value("#{'${select.campaign.name.edit}'}")
  private String CampaignName;
  
  @Value("#{'${xpath.campaignname}'}")
  private String xpathCampaignName;
  
  @Value("#{'${campaign.after.edit}'}")
  private String campaignAfterEdit;
  
  @Value("#{'${xpath.loader.createcampaign}'}")
  String xpathLoadercreatecampaign;
  
  @Value("#{'${xpath.save.edit.campaign}'}")
  String xpathSaveEditCampaign;
  
  @Value("#{'${xpath.loader.editpage}'}")
  String xpathLoaderEditpage;
  
  public String dashboardClassEdit="anticon-edit";
  
  public void verifyCampaignPageEdit(){
    boolean staleElement = true; 
    while(staleElement){
      try {
    assertAndClick(xpathCampaignBtn);
    WebElement element = findWebElement(xpathTableRows, CampaignName);
    System.out.println(CampaignName);
    System.out.println(element);
    element.findElement(By.className("anticon-edit")).click();
    
    
    System.out.println(CampaignName);
    pageReady(xpathLoadercreatecampaign);
    waitForElementVisible(xpathCampaignName);
    
    assertAndClear(xpathCampaignName, 0);
    
    assertAndSendKeys(xpathCampaignName, campaignAfterEdit, 0);
    
    assertAndClick(xpathSaveEditCampaign, 0);
    pageReady(xpathLoaderEditpage);
    
    staleElement = false;
      }catch(StaleElementReferenceException e) {
        staleElement = true;
      }
    }
    
   
  }
  
}