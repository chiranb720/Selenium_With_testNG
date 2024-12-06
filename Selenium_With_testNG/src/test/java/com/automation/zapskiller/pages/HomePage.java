package com.automation.zapskiller.pages;

import com.automation.zapskiller.utils.UIAutomationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automation.zapskiller.config.Hooks.configProps;

public class HomePage extends UIAutomationUtils {

    WebDriver driver;
    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public By signInButton = By.xpath("//span[text()='Sign in']");
    public By registerLink = By.xpath("//a[contains(text(), 'No account? Create one here')]");

    public HomePage clickOnSignIn(){

        clickOnElement(this.signInButton,"Sign In button");
        return this;
    }

    public HomePage clickOnRegisterLink(){
        clickOnElement(this.registerLink, "Registration link");
        return this;
    }

}
