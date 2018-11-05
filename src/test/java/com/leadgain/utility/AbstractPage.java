package com.leadgain.utility;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.leadgain.testcase.BaseClassTest;
import io.qameta.allure.Step;

public class AbstractPage<T> {
  
  protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractPage.class);

    @Autowired
    protected WebDriver webDriver;
    
    @Value(value = "${webdriver.wait}") 
    public Integer webdriverWait;

    @Step("Open url ...")
    public void gotoUrl(String url){
        webDriver.get(url);
    }

    public void waitForElement(String locator) {

        new WebDriverWait(webDriver, webdriverWait)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
    
    public void assertAndVerifyLabel(String expected, String locator) {
        waitForElement(locator);
        assertElementPresentByXpath(locator);
        WebElement headerEle = webDriver.findElement(By.xpath(locator));
        String actual = headerEle.getText();
        assertEquals(actual, expected,
            "Actual Label '" + actual + "' should be same as expected '" + expected + "'.");

    }
    
    public void assertAndVerifyCurrentUrl(String expected) {
        assertEquals( webDriver.getCurrentUrl(), expected,
            "Current Url '" +  webDriver.getCurrentUrl() + "' should be same as expected '" + expected + "'.");
    }
    
    public void assertAndVerifyCurrentUrlNotEqual(String expected) {
      assertNotEquals(webDriver.getCurrentUrl(), expected,
          "Current Url '" +  webDriver.getCurrentUrl() + "' should not be same as expected '" + expected + "'.");
     
  }

    public void assertAndClick(String locator) {
     
        assertElementPresentByXpath(locator);
        webDriver.findElement(By.xpath(locator)).click();
       
    }
    
    
    public void assertAndSendKeys(String locator, String text) {

        assertElementPresentByXpath(locator);
        webDriver.findElement(By.xpath(locator)).sendKeys(text);

    }
    
    public void assertAndSendKeys(String locator, String text, int index) {
     
      assertElementPresentByXpath(locator);
      webDriver.findElements(By.xpath(locator)).get(index).sendKeys(text);
  }
    
    public WebElement findByText(String locator, String textToFind) {
     
      List<WebElement> elementList= webDriver.findElements(By.xpath(locator));
      WebElement result=null;
      for(int i=0;i<elementList.size();i++)
      {
        if(elementList.get(i).getText().equals(textToFind)) {
          result=elementList.get(i);
          break;
        }
      }
      return result;
    }
    
    public void assertElementIsChecked(String locator) {
     // boolean flag=webDriver.findElement(By.xpath(locator)).isSelected();
      assertTrue(webDriver.findElement(By.xpath(locator)).isSelected(), "Checkbox value is not checked");
     
    }


    public void assertElementPresentByXpath(String locator) {
        LOGGER.info("# Verifying element IS present.");
        Assert.assertTrue(isElementPresent(locator), "Element " + locator + " NOT found.");
    }

    public void assertElementNotPresentByXpath(String locator) {
        LOGGER.info("# Verifying element is NOT present.");
        Assert.assertFalse(isElementPresent(locator), "Element " + locator + " IS found.");
    }

    public boolean isElementPresent(String locator) {
        try {
            webDriver.findElement(By.xpath(locator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }


    public boolean isElementVisible(String locator) {

        try {
            return webDriver.findElement(By.xpath(locator)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public void assertElementVisible(String locator, boolean isVisible) {
        LOGGER.info("# Verifying element visibility.");

        if (isVisible)
            Assert.assertTrue(isElementVisible(locator), "Element " + locator + " should be visible.");
        else
            Assert.assertFalse(isElementVisible(locator),
                    "Element " + locator + " should not be visible.");
    }

    public void waitForElementVisible(String locator) {
        new WebDriverWait(webDriver, webdriverWait)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementInVisible(String locator) {
        new WebDriverWait(webDriver, webdriverWait)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    public WebElement getWebElement(String xpath) {
        return webDriver.findElement(By.xpath(xpath));
    }
    
    public boolean moveMouseOut() throws InterruptedException, AWTException {
      System.setProperty("java.awt.headless", "false");
      System.out.println("inside");
      Robot robot = new Robot();
      //robot.delay(1500);
     // Thread.sleep(5000);
      System.out.println("inside move");
      robot.mouseMove(500, 0);
      Thread.sleep(5000);
      robot.mouseMove(500, 500);
      Thread.sleep(2000);
      robot.mouseMove(500, 0);
      Thread.sleep(2000);
      robot.mouseMove(500, 500);
      Thread.sleep(2000);
      robot.mouseMove(500, 0);
      Thread.sleep(2000);
      robot.mouseMove(500, 500);
  return true;
    }

    public boolean pageReady(String locator) {
      boolean pageReady = false;
      while (!pageReady) {
        if(!isElementVisible(locator)) {
          pageReady=true;
        }
      }
      return pageReady;
    }
    
    public void waitForDOMReady(){
      WebDriverWait wait = new WebDriverWait(webDriver, webdriverWait);
      wait.until(new Function () {
            public boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
            @Override
            public Object apply(Object driver) {
              return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        }
      );
    }
    
    public void scrollPage(int scrollToPage){
      Actions actions = new Actions(webDriver);
      for(int i=0;i<(scrollToPage*10);i++) {
          actions.sendKeys(Keys.PAGE_DOWN).perform();
          System.out.println("Page down performed.....");
        }
    }

    public void assertAndClick(String locator, int arrayIndex) {
     
          assertElementPresentByXpath(locator);
          List<WebElement> elements = webDriver.findElements(By.xpath(locator));
          elements.get(arrayIndex).click();
    }
    
    public void assertAndClear(String locator, int arrayIndex) {
      System.out.println("inside clear");
      boolean staleElement = true; 
      while(staleElement){
        try {
      assertElementPresentByXpath(locator);
      List<WebElement> elements = webDriver.findElements(By.xpath(locator));
      elements.get(arrayIndex).clear();
      staleElement = false;
        }catch(StaleElementReferenceException e) {
          staleElement = true;
        }
      }
      System.out.println("inside");
    }
    
    
    public void assertElementPresentByXpath(String locator,int index) {
      LOGGER.info("# Verifying element IS present.");
     // Assert.assertTrue(isElementPresent(locator), "Element " + locator + " NOT found.");
      List<WebElement> elements = webDriver.findElements(By.xpath(locator));
      WebElement actualelem =elements.get(index);
      assertNotNull(actualelem,"WebElement not found.");
    
    }
    
    public void windowFocus(String locator){
      assertElementPresentByXpath(locator);
       webDriver.switchTo().frame(webDriver.findElement(By.xpath(locator)));
      ((JavascriptExecutor) webDriver).executeScript("window.focus();");
      /* String currentWindow = webDriver.getWindowHandle();
       webDriver.switchTo().window(currentWindow);*/
    }
    
    
    public void rowCount(String locator)
    {
      int rowCount = webDriver.findElements(By.xpath(locator)).size();
      System.out.println("rowCount: "+rowCount);
    }
    
    public WebElement findWebElement(String locator, String textToFind) {
      List<WebElement> elements = webDriver.findElements(By.xpath(locator));
      for(WebElement element : elements){
        String text = element.getText();
        if(text.contains(textToFind)) {
          return element;
        }
      }
      return null;
    }
    
    public WebElement findWebElement(String locator1, String locator2, String locator3, String textToFind)
    {
      int rowCount = webDriver.findElements(By.xpath(locator1)).size();
      System.out.println("rowCount: "+rowCount);
    
      List<WebElement> elements = webDriver.findElements(By.xpath(locator2));
      System.out.println(elements);
      for(WebElement element : elements){
        String text = element.getText();
        for(int i=1;i<=rowCount;i++)
        {
          System.out.println(textToFind);
        if(text.contains(textToFind)) 
         // return element;
          System.out.println(text);
          webDriver.findElement(By.xpath(locator3)).click();
          
        }
        }
     
      return null;
    }
    
    public void assertAndSendKeys(String locator, int index) {

      assertElementPresentByXpath(locator);
      webDriver.findElements(By.xpath(locator)).get(index).sendKeys(Keys.ARROW_DOWN);

  }
    
    
    public int assertAndClickGetText(String locator, int arrayIndex) {
      
      assertElementPresentByXpath(locator);
      List<WebElement> elements = webDriver.findElements(By.xpath(locator));
      System.out.println(elements.size());
      System.out.println(elements.get(0));
      System.out.println(elements.get(0).getText());
      int count =Integer.parseInt((elements).get(arrayIndex).getText());
      System.out.println("after assert");
      return count;

    }
    
    public void waitForElementVisible(String locator, int waitTimeInSec) {
      new WebDriverWait(webDriver, waitTimeInSec)
              .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
}
