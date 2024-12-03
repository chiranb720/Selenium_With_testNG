package com.automation.zapskiller.pages;

import com.automation.zapskiller.utils.UIAutomationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends UIAutomationUtils {

    public WebDriver driver;

    public RegistrationPage(WebDriver driver){
        super(driver);
        this.driver = driver;

    }

    public By socialTitle = By.xpath("//input[@id='field-id_gender-1']/..");
    public By firstName = By.id("field-firstname");
    public By lastName = By.id("field-lastname");
    public By emailId = By.id("field-email");
    public By password = By.id("field-password");
    public By birthday = By.id("field-birthday");
    public By recieveOfferLetters = By.name("optin");
    public By termsAndConditions = By.name("psgdpr");
    public By customerPrivacy = By.name("customer_privacy");
    public By saveOption = By.xpath("//button[contains(text(),'Save')]");

    public RegistrationPage clickOnSocialTitle(){
        clickOnElement(this.socialTitle);
        return this;
    }

    public RegistrationPage enterFirstName(String firstName){
        typeIntoField(this.firstName,firstName);
        return this;
    }

    public RegistrationPage enterLastName(String lastName){
        typeIntoField(this.lastName,lastName);
        return this;
    }

    public RegistrationPage enterEmailId(String emailId){
        typeIntoField(this.emailId,emailId);
        return this;
    }

    public RegistrationPage enterPassword(String password){
        typeIntoField(this.password,password);
        return this;
    }

    public RegistrationPage enterBirthday(String birthday){
        typeIntoField(this.birthday,birthday);
        return this;
    }

    public RegistrationPage clickOnRecieveOfferLetters(){
        clickOnElement(this.recieveOfferLetters);
        return this;
    }

    public RegistrationPage clickOnTermsAndConditions(){
        clickOnElement(this.termsAndConditions);
        return this;
    }

    public RegistrationPage clickOnCustomerPrivacy(){
        clickOnElement(this.customerPrivacy);
        return this;
    }

    public RegistrationPage clickOnSaveOption(){
        clickOnElement(this.saveOption);
        return this;
    }

}
