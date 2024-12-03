package com.automation.zapskiller.pages;

import com.automation.zapskiller.utils.UIAutomationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends UIAutomationUtils {

    WebDriver driver;
    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public By signInButton = By.partialLinkText("http://vistacommerce-qa.rf.gd/login");
    public By registerLink = By.xpath("//a[contains(text(), 'No account? Create one here')]");

    public HomePage clickOnSignIn(){
        clickOnElement(this.signInButton);
        return this;
    }

    public HomePage clickOnRegisterLink(){
        clickOnElement(this.registerLink);
        return this;
    }

}
