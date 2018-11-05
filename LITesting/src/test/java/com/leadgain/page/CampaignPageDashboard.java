package com.leadgain.page;

import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import com.leadgain.utility.AbstractPage;

@Component
public class CampaignPageDashboard extends AbstractPage{

  @Value("#{'${xpath.campaignbtn}'}")
  private String xpathCampaignBtn;
  
  @Value("#{'${xpath.table.rows}'}")
  private String xpathTableRows;
  
  @Value("#{'${select.campaign.name}'}")
  private String CampaignName;
  
  @Value("#{'${xpath.visitor}'}")
  String xpathVisitor;
  
  @Value("#{'${xpath.exitintent.count}'}")
  String xpathExitintentCount;
  
  @Value("#{'${xpath.leadsgen.count}'}")
  String xpathLeadsgenCount;
  
  public String dashboardClass= "anticon-line-chart";
  
  public void verifyCampaignPageDashboard(){
    assertAndClick(xpathCampaignBtn);
    WebElement element = findWebElement(xpathTableRows, CampaignName);
    System.out.println(CampaignName);
    element.findElement(By.className(dashboardClass)).click();
  
    waitForElementVisible(xpathVisitor);
    try {
      Thread.sleep(7000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    int VisitorCount= assertAndClickGetText(xpathVisitor, 0);
    System.out.println("Total Visitor:"+VisitorCount);
    
    int exitIntentCount= assertAndClickGetText(xpathExitintentCount, 0);
    System.out.println("Total ExitIntent Count:"+exitIntentCount);
    
    int leadCount= assertAndClickGetText(xpathLeadsgenCount, 0);
    System.out.println("Total Lead Count:"+ leadCount);
    
    Assert.assertTrue(VisitorCount>=exitIntentCount && exitIntentCount >=leadCount, "Visitor count should be greater than exit intent count and lead count");

  
  }
  
    
}
