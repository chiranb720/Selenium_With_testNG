package com.automation.zapskiller.testcases;

import com.automation.zapskiller.config.Hooks;
import com.automation.zapskiller.pages.HomePage;
import com.automation.zapskiller.pages.RegistrationPage;
import org.testng.annotations.Test;

public class RegistrationTestCase extends Hooks {

    public HomePage homePage;
    public RegistrationPage registrationPage;

    @Test
    public void register_new_user_test(){
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);

    }

}
