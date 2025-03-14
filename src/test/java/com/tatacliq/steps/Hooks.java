package com.tatacliq.steps;

import com.tatacliq.utils.ConfigurationManager;
import com.tatacliq.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class Hooks {

    @Before("@web or @android")
    public void setUp(Scenario scenario){
        ConfigurationManager.initializeConfigReader();
        DriverManager.createDriver();
    }

    @Before("@api")
    public void setUpAPI(){
        ConfigurationManager.initializeConfigReader();
        RestAssured.baseURI="https://petstore.swagger.io/";
        RestAssured.useRelaxedHTTPSValidation();
    }

    @After
    public void cleanUp(Scenario scenario){
        if(ConfigurationManager.getConfigValues("application.type").equals("@web")|| ConfigurationManager.getConfigValues("application.type").equals("@android")){
            if (scenario.isFailed()) {
                scenario.attach(ConfigurationManager.attachScreenShot(DriverManager.getDriver()),"image/png","screenshot");
                System.out.println("Test Failed : "+scenario.getName());
            }
        }
        DriverManager.getDriver().quit();
    }
}
