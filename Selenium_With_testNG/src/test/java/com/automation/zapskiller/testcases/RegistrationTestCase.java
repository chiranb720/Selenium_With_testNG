package com.automation.zapskiller.testcases;

import com.automation.zapskiller.config.Hooks;
import com.automation.zapskiller.dataprovider.ExcelDataProvider;
import com.automation.zapskiller.listener.TestOutComeListener;
import com.automation.zapskiller.pages.HomePage;
import com.automation.zapskiller.pages.RegistrationPage;
import com.automation.zapskiller.reporting.ReportListener;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTestCase extends Hooks {

    public HomePage homePage;
    public RegistrationPage registrationPage;

    @Test(dataProviderClass = ExcelDataProvider.class,dataProvider = "user_data_provider",retryAnalyzer = TestOutComeListener.class)
    public void register_new_user_test(String socialTitle,
                                       String firstName,
                                       String lastName,
                                       String email,

                                       String password,
                                       String birthData){
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        homePage.clickOnSignIn().clickOnRegisterLink();
        registrationPage.clickOnSocialTitle().enterFirstName(firstName).enterLastName(lastName).enterEmailId(email)
                .enterPassword(password).enterBirthday(birthData).
                clickOnRecieveOfferLetters().clickOnTermsAndConditions().
                clickOnCustomerPrivacy().clickOnSaveOption();

    }

}
