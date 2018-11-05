package com.leadgain.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import com.leadgain.utility.AbstractPage;

@Component
public class CampaignPageDelete extends AbstractPage{

  @Value("#{'${xpath.campaignbtn}'}")
  private String xpathCampaignBtn;
  
  @Value("#{'${xpath.table.rows}'}")
  private String xpathTableRows;
  
  @Value("#{'${select.campaign.name.delete}'}")
  private String selectCampaignNameDelete;
  
  @Value("#{'${xpath.delete.popup.msg}'}")
  String xpathDeletePopupMsg;
  
  @Value("#{'${xpath.delete.ok}'}")
  String xpathDeleteOk;
  
  @Value("#{'${xpath.loader.delete.campaign}'}")
  String xpathLoaderDeleteCampaign;
  
  public String dashboardClassDelete= "anticon-delete";
  
  public void verifyCampaignPageDelete(){
    assertAndClick(xpathCampaignBtn);
    WebElement element = findWebElement(xpathTableRows, selectCampaignNameDelete);
    System.out.println(selectCampaignNameDelete);
    
    
    element.findElement(By.className(dashboardClassDelete)).click();
    
    waitForElementVisible(xpathDeletePopupMsg);
    waitForElementVisible(xpathDeleteOk);
    
    assertAndClick(xpathDeleteOk, 0);
    pageReady(xpathLoaderDeleteCampaign);
    
    WebElement element1 = findWebElement(xpathTableRows, selectCampaignNameDelete);
    
    Assert.assertNull(element1, "Campaign" +selectCampaignNameDelete+ "not deleted");
   
  }
  
 
  
}
