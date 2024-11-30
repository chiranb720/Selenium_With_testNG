package com.automation.zapskiller.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

public class Hooks {
    public static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    public static Properties configProps;

    @BeforeSuite
    public void BeforeSuite(){

    }


}
