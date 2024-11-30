package com.automation.zapskiller.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UIAutomationUtils {

    public static final Logger logger = LoggerFactory.getLogger(UIAutomationUtils.class);

    /**
     * This method reads a properties/config file and its properties
     * @return
     * @version 1.0
     */
    public static Properties readConfig(){

        try {
            FileInputStream fis = new FileInputStream("src/test/resource/config-qa.properties");
            Properties props = new Properties();
            props.load(fis);
            return props;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
