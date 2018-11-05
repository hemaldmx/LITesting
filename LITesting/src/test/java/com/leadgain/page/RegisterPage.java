package com.leadgain.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.leadgain.dto.RegistrationDto;
import com.leadgain.email.User;
import com.leadgain.utility.AbstractPage;

@Component
public class RegisterPage extends AbstractPage{
  @Autowired
  private User user;
  
  @Value("#{'${xpath.register}'}")
  private String xpathRegister;
  
  @Value("#{'${xpath.company}'}")
  private String xpathCompany;
  
  @Value("#{'${xpath.fname}'}")
  private String xpathFname;
  
  
  @Value("#{'${xpath.lname}'}")
  private String xpathLname;
  
  @Value("#{'${xpath.add1}'}")
  private String xpathAdd1;
  
  @Value("#{'${xpath.add2}'}")
  private String xpathAdd2;
  
  @Value("#{'${xpath.email}'}")
  private String xpathEmail;
  
  @Value("#{'${xpath.city}'}")
  private String xpathCity;
  
  @Value("#{'${xpath.state}'}")
  private String xpathState;
  
  @Value("#{'${xpath.country}'}")
  private String xpathCountry;
  
  @Value("#{'${xpath.zip}'}")
  private String xpathZip;
  
  @Value("#{'${xpath.phone}'}")
  private String xpathPhone;
  
  @Value("#{'${xpath.registerbutton}'}")
  private String xpathRegisterBotton;
  
  @Value("#{'${xpath.cancelbutton}'}")
  private String xpathCancelButton;
  
 // user.setEmail(java.util.UUID.randomUUID()+"@gmail.com");
//webDriver.findElement(By.id("email")).sendKeys(user.getEmail());

  public void verifyRegistrationWithValidData(RegistrationDto registrationDto){
    String url=webDriver.getCurrentUrl();
    assertAndClick(xpathRegister);
    assertAndSendKeys(xpathCompany, registrationDto.getCompanyName());
    assertAndSendKeys(xpathFname, registrationDto.getFirstName());
    assertAndSendKeys(xpathLname, registrationDto.getLastName());
    assertAndSendKeys(xpathAdd1, registrationDto.getAddress1());
    assertAndSendKeys(xpathAdd2, registrationDto.getAddress2());
  assertAndSendKeys(xpathEmail, registrationDto.getEmail());
    assertAndSendKeys(xpathCity, registrationDto.getCity());
    assertAndSendKeys(xpathState, registrationDto.getState());
    assertAndSendKeys(xpathCountry, registrationDto.getCountry());
    assertAndSendKeys(xpathZip, registrationDto.getZip());
    assertAndSendKeys(xpathPhone, registrationDto.getCompanyName());
    
    assertAndClick(xpathRegisterBotton); 
    assertAndVerifyCurrentUrlNotEqual(url);
                   
}

  public void checkCancelButton(RegistrationDto registrationDto) {
    String url=webDriver.getCurrentUrl();
    assertAndClick(xpathRegister);
    assertAndSendKeys(xpathCompany, registrationDto.getCompanyName());
    assertAndSendKeys(xpathFname, registrationDto.getFirstName());
      
    assertAndClick(xpathCancelButton); 
    assertAndVerifyCurrentUrlNotEqual(url);
    
  }
  
}
