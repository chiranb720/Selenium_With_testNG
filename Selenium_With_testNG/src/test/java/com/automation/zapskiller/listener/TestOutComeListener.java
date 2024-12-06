package com.automation.zapskiller.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestOutComeListener implements IRetryAnalyzer {

    int maxRetryCount = 1;
    int maxCount = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE && maxRetryCount < maxCount) {
            maxRetryCount++;
            return true;
        } else {
            return false;
        }
    }

}



