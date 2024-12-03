package com.automation.zapskiller.dataprovider;

import com.automation.zapskiller.config.Hooks;
import com.automation.zapskiller.utils.UIAutomationUtils;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {


    @DataProvider(name = "user_data_provider")
    public String[][] getTestData(){
        return UIAutomationUtils.readTestData(Hooks.configProps.getProperty("test.datasource"),"users");
    }
}
