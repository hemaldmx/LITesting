package com.leadgain.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import com.leadgain.email.User;
import com.leadgain.utility.AbstractPage;

@Component
public class CreateCampaignPage extends AbstractPage {
  
  @Value("#{'${xpath.username}'}")
  private String xpathUsername;
  
  @Value("#{'${xpath.password}'}")
  private String xpathPassword;
  
  @Value("#{'${xpath.loginbtn}'}")
  private String xpathLoginBtn;

    @Value("#{'${xpath.campaignbtn}'}")
    private String xpathCampaignBtn;
    
    @Value("#{'${xpath.createcampaignbtn}'}")
    private String xpathCreateCampaignBtn;
    
    @Value("#{'${xpath.campaignname}'}")
    private String xpathCampaignName;
    
    @Value("#{'${xpath.type}'}")
    private String xpathType;
    
    @Value("#{'${xpath.selecttype}'}")
    private String xpathSelectType;
    
    @Value("#{'${xpath.campaignurl}'}")
    private String xpathCampaignUrl;
    
    @Value("#{'${xpath.popupurl}'}")
    private String xpathPopupUrl;
    
    @Value("#{'${xpath.title}'}")
    private String xpathTitle;
    
    @Value("#{'${xpath.roi}'}")
    private String xpathRoi;
    
    @Value("#{'${xpath.description}'}")
    private String xpathDescription;
    
    @Value("#{'${xpath.campaignmail}'}")
    private String xpathCampaignMail;
    
    @Value("#{'${xpath.createbtn}'}")
    private String xpathCreateBtn;
    
    @Value("#{'${xpath.cancelbutton}'}")
    private String xpathCancelButton;
    
    @Value("#{'${xpath.loader}'}")
    String xpathLoader;
    
    @Value("#{'${xpath.loader.createcampaign}'}")
    String xpathLoadercreatecampaign;
    
    @Value("#{'${xpath.loader.campaign}'}")
    String xpathLoaderCampaign;
    
    @Value("#{'${xpath.startcampaignbtn}'}")
    String xpathStartCampaignBtn;
    
    @Value("#{'${xpath.loader.campaignstart}'}")
    String xpathLoaderCampaignStrt;
    
    @Value("#{'${xpath.delete.campaign}'}")
    String xpathDeleteCampaign;
    
    @Value("#{'${campaign.campaignnamevalue}'}")
    String campaignName;
    
    @Value("#{'${xpath.delete.button}'}")
    String xpathDeleteBtn;
    
    @Value("#{'${xpath.adv}'}")
    String xpathAdvWindow;
    
    @Value("#{'${xpath.msg.heading}'}")
    String xpathAdvMsgHeading;
    
    @Value("#{'${create.campaign.splashheading.val}'}")
    String campaignSplashheadingVal;
    
    @Value("#{'${xpath.msg.subheading}'}")
    String xpathAdvMsgSubHeading;
    
    @Value("#{'${create.campaign.splashsubheading.val}'}")
    String campaignSplashSubheadingVal;
    
    @Value("#{'${xpath.email.heading}'}")
    String xpathEmailHeading;
    
    @Value("#{'${create.campaign.emailboxheading.val}'}")
    String campaignEmailboxHeadingVal;
    
    @Value("#{'${xpath.email.subheading}'}")
    String xpathEmailSubHeading;
    
    @Value("#{'${create.campaign.emailboxsubheading.val}'}")
    String campaignEmailboxSubHeadingVal;
    
    @Value("#{'${xpath.email.on}'}")
    String xpathEmailOn;
    
    @Value("#{'${create.campaign.thanksmsgmailon.val}'}")
    String campaignThanksEmailOn;
    
    @Value("#{'${xpath.email.off}'}")
    String xpathEmailOff;
    
    @Value("#{'${create.campaign.thanksmsgmailoff.val}'}")
    String campaignThanksEmailoff;
    
    @Value("#{'${xpath.manageteaser}'}")
    String xpathManageTeaser;
    
    @Value("#{'${xpath.teaser.page.slide}'}")
    String xpathPageForSlide;   
    
    @Value("#{'${manage.teaser.slide}'}")
    String manageTeaserSlide;
    
    @Value("#{'${xpath.teaser.add.more.slide}'}")
    String xpathTeaserAddMoreSlide;
    
    @Value("#{'${xpath.teaser.page.new.slide}'}")
    String xpathManageTeaserPageNewSlide;
    
    @Value("#{'${xpath.teaser.slide.3}'}")
    String xpathTeaserSlide3;
    
    @Value("#{'${xpath.teaser.key.up}'}")
    String xpathTeaserKeyUp;

    @Value("#{'${xpath.slide.key.down}'}")
    String xpathSlideKeyDown;
    
    @Value("#{'${xpath.add.new.slide}'}")
    String xpathAddNewSlide;
    
    @Value("#{'${xpath.teaser.slide.4}'}")
    String xpathTeaserSlide4;
    
    @Value("#{'${xpath.teaser.remove.btn}'}")
    String xpathTeaserRemoveBtn;
    
    @Value("#{'${xpath.teaser.manage.question}'}")
    String xpathTeaserManageQs;
    
    @Value("#{'${xpath.teaser.add.question.button}'}")
    String xpathTeaserAddQuestionButton;
    
    @Value("#{'${xpath.manageqs.qs.text}'}")
    String xpathManageqsQsText;
    
    @Value("#{'${enter.question1.text.val}'}")
    String enterQuestion1TextVal;
    
    @Value("#{'${xpath.option1}'}")
    String xpathOption1;
    
    @Value("#{'${question1.answer.option-1.val}'}")
    String question1AnswerOption1Val;
    
    @Value("#{'${xpath.opt2.add.option}'}")
    String xpathOpt2AddOption;
    
    @Value("#{'${question1.answer.option-2.val}'}")
    String question1AnswerOption2Val;
    
    @Value("#{'${xpath.option2}'}")
    String xpathOption2;
    
    @Value("#{'${xpath.opt3.add.option}'}")
    String xpathOpt3AddOption;
    
    @Value("#{'${question1.answer.option-3.val}'}")
    String question1AnswerOption3Val;
    
    @Value("#{'${xpath.option3}'}")
    String xpathOption3;
    
    @Value("#{'${xpath.opt4.add.option}'}")
    String xpathOpt4AddOption;
    
    @Value("#{'${xpath.opt4.del.btn}'}")
    String xpathOpt4DelBtn;
    
    @Value("#{'${xpath.add.btn}'}")
    String xpathAddBtn;
    
    @Value("#{'${xpath.select.qs.type}'}")
    String xpathSelectQsType;
    
    @Value("#{'${xpath.select.radio.btn}'}")
    String xpathSelectRadioBtn;
    
    @Value("#{'${xpath.adv.automation.settings}'}")
    String xpathAdvAutomationSettings;
    
    @Value("#{'$xpath.lead.qualification}'}")
    String xpathLeadQualification;
    
    @Value("#{'${xpath.marketing.automation}'}")
    String xpathMarketingAutomation;
    
    @Value("#{'${xpath.instant.marketing.automation}'}")
    String xpathInstantMarketingAutomation;
    
    @Value("#{'${xpath.table.rows}'}")
    private String xpathTableRows;
    
    @Value("#{'${xpath.delete.popup.msg}'}")
    String xpathDeletePopupMsg;
    
    @Value("#{'${xpath.delete.ok}'}")
    String xpathDeleteOk;
    
    @Value("#{'${xpath.loader.delete.campaign}'}")
    String xpathLoaderDeleteCampaign;
    
    public String dashboardClassDelete= "anticon-delete";
    
    public void verifyLoginWithoutAssert(String username, String password) {
      // String url=webDriver.getCurrentUrl();
       assertAndSendKeys(xpathUsername, username);
       assertAndSendKeys(xpathPassword, password);
       assertAndClick(xpathLoginBtn);
                           
   }
    
    public void createCamapignMandatoryFields (String campaignname,String campaignurl, String popupurl, String title) throws InterruptedException {
      boolean staleElement = true; 
      while(staleElement){
        try {
        assertAndClick(xpathCampaignBtn);
        pageReady(xpathLoadercreatecampaign);
        assertAndClick(xpathCreateCampaignBtn, 0);
        waitForElementVisible(xpathCampaignName);
        assertAndSendKeys(xpathCampaignName, campaignname, 0);
        assertAndClick(xpathType);
        assertAndClick(xpathSelectType, 0);
        assertAndSendKeys(xpathCampaignUrl, campaignurl);
        assertAndSendKeys(xpathPopupUrl, popupurl);
        assertAndSendKeys(xpathTitle, title);
        assertAndClick(xpathCreateBtn, 0);
        pageReady(xpathLoaderCampaign);
        assertAndClick(xpathStartCampaignBtn, 0);
        pageReady(xpathLoaderCampaignStrt);
        
        waitForDOMReady();
        Thread.sleep(7000);
        
        assertAndClick(xpathCampaignBtn);
        WebElement element = findWebElement(xpathTableRows, campaignName);
        System.out.println(campaignName);
        
        Assert.assertNotNull(element, "Campaign" +campaignName+ "not created successfully");
        
        staleElement = false;
        }catch(StaleElementReferenceException e) {
          staleElement = true;
        }
      }
      }
     
    public void createCamapignAdvanceManageMsg (String campaignname,String campaignurl, String popupurl, String title) throws InterruptedException {
      
      assertAndClick(xpathCampaignBtn);
      pageReady(xpathLoadercreatecampaign);
      assertAndClick(xpathCreateCampaignBtn, 0);
      assertAndSendKeys(xpathCampaignName, campaignname, 0);
      assertAndClick(xpathType);
      assertAndClick(xpathSelectType, 0);
      assertAndSendKeys(xpathCampaignUrl, campaignurl);
      assertAndSendKeys(xpathPopupUrl, popupurl);
      assertAndSendKeys(xpathTitle, title);
      assertAndClick(xpathAdvWindow, 0);
      waitForElementVisible(xpathAdvMsgHeading);
      assertAndClear(xpathAdvMsgHeading, 0);
      assertAndSendKeys(xpathAdvMsgHeading, campaignSplashheadingVal);
      assertAndClear(xpathAdvMsgSubHeading, 0);
      assertAndSendKeys(xpathAdvMsgSubHeading, campaignSplashSubheadingVal);
      assertAndClear(xpathEmailHeading, 0);
      assertAndSendKeys(xpathEmailHeading, campaignEmailboxHeadingVal);
      assertAndSendKeys(xpathEmailSubHeading, campaignEmailboxSubHeadingVal);
      assertAndClear(xpathEmailOn, 0);
      assertAndSendKeys(xpathEmailOn, campaignThanksEmailOn);
      assertAndClear(xpathEmailOff, 0);
      assertAndSendKeys(xpathEmailOff, campaignThanksEmailoff);
      
      assertAndClick(xpathCreateBtn, 0);
      pageReady(xpathLoaderCampaign);
      assertAndClick(xpathStartCampaignBtn, 0);
      pageReady(xpathLoaderCampaignStrt);
//      findWebElement(xpathDeleteCampaign, campaignName);
//      assertAndClick(xpathDeleteBtn);
    }
    
 public void createCamapignManageTeaser (String campaignname,String campaignurl, String popupurl, String title) throws InterruptedException {
   boolean staleElement = true; 
   while(staleElement){
     try {
      assertAndClick(xpathCampaignBtn);
      pageReady(xpathLoadercreatecampaign);
      assertAndClick(xpathCreateCampaignBtn, 0);
      assertAndSendKeys(xpathCampaignName, campaignname, 0);
      assertAndClick(xpathType);
      assertAndClick(xpathSelectType, 0);
      assertAndSendKeys(xpathCampaignUrl, campaignurl);
      assertAndSendKeys(xpathPopupUrl, popupurl);
      assertAndSendKeys(xpathTitle, title);
      assertAndClick(xpathAdvWindow, 0);
      
      assertAndClick(xpathManageTeaser,0);            
      waitForElementVisible(xpathPageForSlide);
      assertAndClear(xpathPageForSlide, 0);
      assertAndSendKeys(xpathPageForSlide, manageTeaserSlide);
      assertAndClick(xpathTeaserAddMoreSlide, 0);
      
      assertAndClick(xpathManageTeaserPageNewSlide, 0);
      waitForElementVisible(xpathSlideKeyDown);
      assertAndClick(xpathSlideKeyDown, 0);
      
      assertAndClick(xpathAddNewSlide, 0);
      
      assertAndClick(xpathTeaserSlide3, 0);
      waitForElementVisible(xpathTeaserKeyUp);
      assertAndClick(xpathTeaserKeyUp, 0);
      
      assertAndClick(xpathTeaserSlide4, 0);
      assertAndClick(xpathTeaserRemoveBtn, 0);
      
      Thread.sleep(8000);
//      assertAndClick(xpathCreateBtn, 0);
//      pageReady(xpathLoaderCampaign);
//      assertAndClick(xpathStartCampaignBtn, 0);
//      pageReady(xpathLoaderCampaignStrt);
//      findWebElement(xpathDeleteCampaign, campaignName);
//      assertAndClick(xpathDeleteBtn);
      staleElement = false;
     }catch(StaleElementReferenceException e) {
       staleElement = true;
     }
   }
   
 }
 
 public void createCamapignManageQuestionCheckbox (String campaignname,String campaignurl, String popupurl, String title) throws InterruptedException {
   boolean staleElement = true; 
   while(staleElement){
     try {
      assertAndClick(xpathCampaignBtn);
      pageReady(xpathLoadercreatecampaign);
      assertAndClick(xpathCreateCampaignBtn, 0);
      assertAndSendKeys(xpathCampaignName, campaignname, 0);
      assertAndClick(xpathType);
      assertAndClick(xpathSelectType, 0);
      assertAndSendKeys(xpathCampaignUrl, campaignurl);
      assertAndSendKeys(xpathPopupUrl, popupurl);
      assertAndSendKeys(xpathTitle, title);
      waitForElementVisible(xpathAdvWindow);
      assertAndClick(xpathAdvWindow, 0);
      waitForElementVisible(xpathTeaserManageQs);
      assertAndClick(xpathTeaserManageQs, 0);
      
      Thread.sleep(8000);
      
      waitForElementVisible(xpathTeaserAddQuestionButton);
      assertAndClick(xpathTeaserAddQuestionButton, 0);            
      
      assertAndClick(xpathManageqsQsText, 0);
      assertAndSendKeys(xpathManageqsQsText, enterQuestion1TextVal);
      
      assertAndClick(xpathOption1, 0);
      assertAndSendKeys(xpathOption1, question1AnswerOption1Val);
      
      assertAndClick(xpathOpt2AddOption, 0);
      
      assertAndClick(xpathOption2, 0);
      assertAndSendKeys(xpathOption2, question1AnswerOption2Val);
      
      assertAndClick(xpathOpt3AddOption, 0);
      
      assertAndClick(xpathOption3, 0);
      assertAndSendKeys(xpathOption3, question1AnswerOption3Val);
      
      assertAndClick(xpathOpt4AddOption, 0);
      assertAndClick(xpathOpt4DelBtn, 0);

        Thread.sleep(8000);
//      assertAndClick(xpathCreateBtn, 0);
//      pageReady(xpathLoaderCampaign);
//      assertAndClick(xpathStartCampaignBtn, 0);
//      pageReady(xpathLoaderCampaignStrt);
//      findWebElement(xpathDeleteCampaign, campaignName);
//      assertAndClick(xpathDeleteBtn);
      staleElement = false;
     }catch(StaleElementReferenceException e) {
       staleElement = true;
     }
   }
   
 }

 public void createCamapignManageQuestionRadioBtn (String campaignname,String campaignurl, String popupurl, String title) throws InterruptedException {
   boolean staleElement = true; 
   while(staleElement){
     try {
      assertAndClick(xpathCampaignBtn);
      pageReady(xpathLoadercreatecampaign);
      assertAndClick(xpathCreateCampaignBtn, 0);
      assertAndSendKeys(xpathCampaignName, campaignname, 0);
      assertAndClick(xpathType);
      assertAndClick(xpathSelectType, 0);
      assertAndSendKeys(xpathCampaignUrl, campaignurl);
      assertAndSendKeys(xpathPopupUrl, popupurl);
      assertAndSendKeys(xpathTitle, title);
      waitForElementVisible(xpathAdvWindow);
      assertAndClick(xpathAdvWindow, 0);
      waitForElementVisible(xpathTeaserManageQs);
      assertAndClick(xpathTeaserManageQs, 0);
      
      Thread.sleep(8000);
      
      waitForElementVisible(xpathTeaserAddQuestionButton);
      assertAndClick(xpathTeaserAddQuestionButton, 0);            
      
      assertAndClick(xpathSelectQsType, 0);
      
      waitForElementVisible(xpathSelectRadioBtn);      
      assertAndClick(xpathSelectRadioBtn, 0);
      
      assertAndClick(xpathManageqsQsText, 0);
      assertAndSendKeys(xpathManageqsQsText, enterQuestion1TextVal);
      
      assertAndClick(xpathOption1, 0);
      assertAndSendKeys(xpathOption1, question1AnswerOption1Val);
      
      assertAndClick(xpathOpt2AddOption, 0);
      
      assertAndClick(xpathOption2, 0);
      assertAndSendKeys(xpathOption2, question1AnswerOption2Val);
      
      assertAndClick(xpathOpt3AddOption, 0);
      
      assertAndClick(xpathOption3, 0);
      assertAndSendKeys(xpathOption3, question1AnswerOption3Val);
      
      assertAndClick(xpathOpt4AddOption, 0);
      assertAndClick(xpathOpt4DelBtn, 0);

        Thread.sleep(8000);
//      assertAndClick(xpathCreateBtn, 0);
//      pageReady(xpathLoaderCampaign);
//      assertAndClick(xpathStartCampaignBtn, 0);
//      pageReady(xpathLoaderCampaignStrt);
//      findWebElement(xpathDeleteCampaign, campaignName);
//      assertAndClick(xpathDeleteBtn);
      staleElement = false;
     }catch(StaleElementReferenceException e) {
       staleElement = true;
     }
   }
   
 }
 
 public void createCamapignAutomationSettings (String campaignname,String campaignurl, String popupurl, String title) throws InterruptedException {
   boolean staleElement = true; 
   while(staleElement){
     try {
      assertAndClick(xpathCampaignBtn);
      pageReady(xpathLoadercreatecampaign);
      assertAndClick(xpathCreateCampaignBtn, 0);
      assertAndSendKeys(xpathCampaignName, campaignname, 0);
      assertAndClick(xpathType);
      assertAndClick(xpathSelectType, 0);
      assertAndSendKeys(xpathCampaignUrl, campaignurl);
      assertAndSendKeys(xpathPopupUrl, popupurl);
      assertAndSendKeys(xpathTitle, title);
      waitForElementVisible(xpathAdvWindow);
      assertAndClick(xpathAdvWindow, 0);
      waitForElementVisible(xpathAdvAutomationSettings);
      assertAndClick(xpathAdvAutomationSettings, 0);
      
      Thread.sleep(3000);
     
      waitForElementVisible(xpathLeadQualification);
      assertAndClick(xpathLeadQualification, 0);            
      
           
    //  waitForElementVisible(xpathMarketingAutomation);      
    //  assertAndClick(xpathMarketingAutomation, 0);
   //   
      waitForElementVisible(xpathInstantMarketingAutomation);
     // assertAndClick(xpathInstantMarketingAutomation, 0);
      
      Thread.sleep(8000);
//      assertAndClick(xpathCreateBtn, 0);
//      pageReady(xpathLoaderCampaign);
//      assertAndClick(xpathStartCampaignBtn, 0);
//      pageReady(xpathLoaderCampaignStrt);
//      findWebElement(xpathDeleteCampaign, campaignName);
//      assertAndClick(xpathDeleteBtn);
      staleElement = false;
     }catch(StaleElementReferenceException e) {
       staleElement = true;
     }
   }
   
 }

    
}
