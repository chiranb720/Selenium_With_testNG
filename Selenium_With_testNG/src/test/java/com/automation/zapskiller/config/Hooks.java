package com.automation.zapskiller.config;

import com.automation.zapskiller.utils.UIAutomationUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class Hooks {
    public static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    public static Properties configProps;
    public WebDriver driver;
    public ChromeOptions options = new ChromeOptions();

    @BeforeSuite
    public void BeforeSuite(){
        configProps = UIAutomationUtils.readConfig();
    }

    @BeforeTest
    public void beforeTest(){
        launchBrowser();

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
        if(configProps.getProperty("browser").equalsIgnoreCase("browser")){
            if(configProps.getProperty("browser.chrome.options.headless").equalsIgnoreCase("true")){
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

    }


    /**
     * <p>This Method Is Used To Terminate Webdriver Session</p>
     * @version 1.0
     */
    public void closeBrowser(){

        driver.quit();
    }


}
