package com.automation.zapskiller.utils;


import com.aventstack.extentreports.Status;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static com.automation.zapskiller.config.Hooks.configProps;
import static com.automation.zapskiller.config.Hooks.wait;
import static com.automation.zapskiller.reporting.ReportListener.test;

public class UIAutomationUtils {

    public static final Logger logger = LoggerFactory.getLogger(UIAutomationUtils.class);
    WebDriver driver;
    public static FileInputStream fis;

    public UIAutomationUtils(WebDriver driver){
        this.driver =driver;
    }


    /**
     * This method reads a properties/config file and its properties
     * @return
     * @version 1.0
     */
    public static Properties readConfig(){

        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config-qa.properties");
            Properties props = new Properties();
            props.load(fis);
            return props;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[][] readTestData(String filepath,String tabName){

        try {
            fis = new FileInputStream(readConfig().getProperty("test.datasource"));
            DataFormatter formatter = new DataFormatter();
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheet(tabName);
            int row = sheet.getLastRowNum();
            int col = sheet.getRow(0).getLastCellNum();
            String[][] data = new String[row][col];
            for(int i=1;i<=row;i++){
                for(int j=0;j<col;j++){
                    Cell cell = sheet.getRow(i).getCell(j);
                    String cellValue = formatter.formatCellValue(cell);
                    data[i-1][j] = cellValue;

                }
            }
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    /**
//     * <p>Waits for Visibility of WebElement for configured number of seconds</p>
//     * @param locator
//     * @Version 1.0
//     */
//    public void waitForElementVisibility(By locator) {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(configProps.getProperty("webdriver.wait.inseconds"))));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
//    }



    /**
     * <p>This method is used gto click on an element</p>
     * @param element
     * @Version 1.0
     */
    public void clickOnElement(By element,String elementName){
        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
            test.log(Status.INFO,"Clicking on element "+elementName);
        }catch(Exception e){
            test.log(Status.FAIL,"Unable to click on element "+elementName);
            Assert.fail();
        }
    }

    /**
     * <p>This method is used to enter a value into textfield</p>
     * @param element
     * @param inputValue
     */
    public void typeIntoField(By element,String inputValue){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(inputValue);
            test.log(Status.INFO,"Entering value Into input box "+inputValue);
        }catch(Exception e){
            test.log(Status.FAIL,"Unable to enter values in the input box");
        }
    }


}
