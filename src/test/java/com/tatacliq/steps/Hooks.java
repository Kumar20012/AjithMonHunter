package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidFilterPage;
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
        scenario.attach(ConfigurationManager.attachScreenShot(DriverManager.getDriver()),"image/png","screenshot");
        //DriverManager.getDriver().quit();
    }
}
