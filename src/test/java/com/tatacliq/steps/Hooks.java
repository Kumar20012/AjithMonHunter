package com.tatacliq.steps;

import com.tatacliq.utils.ConfigurationManager;
import com.tatacliq.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(){
        ConfigurationManager.initializeConfigReader();
        DriverManager.createDriver();
    }

    @After
    public void cleanUp(Scenario scenario){
        if(scenario.isFailed()) {
            scenario.attach(ConfigurationManager.attachScreenShot(DriverManager.getDriver()), "image/png", "screenshot");
        }
        //DriverManager.getDriver().quit();
    }
}
