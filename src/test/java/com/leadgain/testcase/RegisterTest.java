package com.leadgain.testcase;

import java.lang.reflect.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.leadgain.dto.RegistrationDto;
import com.leadgain.email.User;
import com.leadgain.extent.ExtentTestManager;
import com.leadgain.listener.TestListener;
import com.leadgain.page.LoginPage;
import com.leadgain.page.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Register Tests")

public class RegisterTest extends BaseClassTest {

  @Value("#{'${register.company}'}")
  String company_name;

@Value("#{'${register.fname}'}")
  String f_name;

@Value("#{'${register.lname}'}")
  String l_name;
      
@Value("#{'${register.add1}'}")
  String add_1;

@Value("#{'${register.add2}'}")
  String add_2;

@Value("#{'${register.city}'}")
  String city_name;
       
@Value("#{'${register.state}'}")
  String state_name;
      
@Value("#{'${register.country}'}")
  String country_name;
      
@Value("#{'${register.zip}'}")
 String zip_code;

@Value("#{'${register.ph}'}")
  String ph_no;

@Autowired
private RegisterPage registerPage;

@Autowired
private LoginPage loginPage;

private String email;
 
@Test (priority = 1, groups= {"regression","smoke"}, description="Valid Register.")
@Severity(SeverityLevel.BLOCKER)
@Description("Test Description: Register User.")
//@Story("Invalid username and password login test")



public void validUserRegisteration (Method method) throws InterruptedException {
    LOGGER.info(method.getName() + " test is starting.");

    registerPage.gotoUrl(url);
    //ExtentReports Description
    ExtentTestManager.getTest().setDescription("Valid User Registartion.");

   
    LOGGER.info("Trying to Register LeadGain.");
    RegistrationDto reg = new RegistrationDto();
    reg.setCompanyName(company_name);
    reg.setFirstName(f_name);
    reg.setLastName(l_name);
    reg.setAddress1(add_1);
    reg.setAddress2(add_2);
 
    reg.setCity(city_name);
    reg.setState(state_name);
    reg.setCountry(country_name);
    reg.setZip(zip_code);
    reg.setPhone(ph_no);
  
    email=reg.getEmail();
    
    registerPage.verifyRegistrationWithValidData(reg);
}


@Test (priority=2)
public void LoginTest_AfterRegistration () throws InterruptedException {
  //ExtentReports Description
  ExtentTestManager.getTest().setDescription("Check Login after Registartion");
  
  loginPage.gotoUrl(url);
  
  Thread.sleep(500);
  loginPage.verifyLogin(email,"123456");
}

@Test (priority = 3, groups= {"regression","smoke"}, description="Check Cancel Button.")
@Severity(SeverityLevel.BLOCKER)
@Description("Test Description: Check Cancel Button.")
//@Story("Invalid username and password login test")



public void checkCancelButton (Method method) throws InterruptedException {
    LOGGER.info(method.getName() + " test is starting.");

    registerPage.gotoUrl(url);
    //ExtentReports Description
    ExtentTestManager.getTest().setDescription("Check Cancel Button");

   
    LOGGER.info("Checking Cancel Button.");
    RegistrationDto reg = new RegistrationDto();
    reg.setCompanyName(company_name);
    reg.setFirstName(f_name);
        
    registerPage.checkCancelButton(reg);
}

  
/**
 * @return the email
 */
public String getEmail() {
  return email;
}

/**
 * @param email the email to set
 */
public void setEmail(String email) {
  this.email = email;
}

}
