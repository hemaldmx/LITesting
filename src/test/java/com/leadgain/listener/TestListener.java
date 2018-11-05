package com.leadgain.listener;

import com.leadgain.config.ContextProvider;
import com.leadgain.extent.ExtentManager;
import com.leadgain.extent.ExtentTestManager;
import com.leadgain.testcase.BaseClassTest;
import com.relevantcodes.extentreports.LogStatus;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseClassTest implements ITestListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestListener.class);
  
    
    private WebDriver webDriver;
    
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    //Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG (WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog (String message) {
        return message;
    }

    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        LOGGER.info("Invoke method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", webDriver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LOGGER.info("Exit method " + iTestContext.getName());
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("Calling method " +  getTestMethodName(iTestResult) + " start");
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info("Success method " +  getTestMethodName(iTestResult) + " succeed");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.info("Failure method " +  getTestMethodName(iTestResult) + " failed");

        Object testClass = iTestResult.getInstance();

        if (getWebDriver() instanceof WebDriver) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveScreenshotPNG(getWebDriver());
        }

        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");

        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)getWebDriver()).
                getScreenshotAs(OutputType.BASE64);

        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

    public WebDriver getWebDriver() {
      return (WebDriver) ContextProvider.getBean("webDriver");
    }

}
