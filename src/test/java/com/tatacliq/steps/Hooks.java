package com.tatacliq.steps;

import com.tatacliq.utils.ConfigurationManager;
import com.tatacliq.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        ConfigurationManager.initializeConfigReader();
        DriverManager.createDriver();
    }

    @After
    public void cleanUp(){
        //DriverManager.getDriver().quit();
    }
}
