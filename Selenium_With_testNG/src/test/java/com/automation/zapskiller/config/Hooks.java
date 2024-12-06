package com.automation.zapskiller.config;

import com.automation.zapskiller.utils.UIAutomationUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Properties;

import static com.automation.zapskiller.reporting.ReportListener.test;

public class Hooks {
    public static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    public static Properties configProps;
    public WebDriver driver;
    public ChromeOptions options = new ChromeOptions();
    public static Wait<WebDriver> wait;

    @BeforeSuite
    public void BeforeSuite(){
        configProps = UIAutomationUtils.readConfig();
    }

    @BeforeTest
    public void beforeTest(){
        launchBrowser();
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(Long.parseLong(configProps.getProperty("webdriver.wait.inseconds"))))
                .pollingEvery(Duration.ofSeconds(2L))
                .ignoring(NoSuchElementException.class);
        navigateToUrl(configProps.getProperty("project.url"));

    }

    @AfterTest
    public void afterTest(){
        closeBrowser();
    }


    /**
     * <p>Launches a Browser Based On Provided Config Params</p>
     * @Version 1.0
     */
    public void launchBrowser(){

        if(configProps.getProperty("browser").equalsIgnoreCase("CHROME")){

            if(configProps.getProperty("browser.chrome.options.headless").equalsIgnoreCase("true")){
                options.addArguments("--headless");
            }

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        System.out.println("initiating driver12");

    }


    /**
     * <p>This Method Is Used To Terminate Webdriver Session</p>
     * @version 1.0
     */
    public void closeBrowser(){

        driver.quit();
    }

    /**
     * <p>This method is used to navigate to given url</p>
     * @param url
     */

    public void navigateToUrl(String url){

        driver.get(url);
//        test.log(Status.INFO,"Navigating to "+url);
    }




}
