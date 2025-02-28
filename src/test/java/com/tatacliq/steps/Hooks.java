package com.tatacliq.steps;

import com.aventstack.extentreports.ExtentTest;
import com.tatacliq.utils.ConfigurationManager;
import com.tatacliq.utils.DriverManager;
import com.tatacliq.utils.ExtentReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before("@web or @android")
    public void setUp(Scenario scenario){
        ConfigurationManager.initializeConfigReader();
        ExtentReportManager.initReporter();
        ExtentReportManager.createTest(scenario.getName());
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
            if (scenario.isFailed()) {
                ExtentReportManager.attachScreenshot();
                ExtentReportManager.getTest().fail("Test Failed : "+scenario.getName());
            } else {
                ExtentReportManager.getTest().pass("Test Passed : " + scenario.getName());
            }
            try {
                Thread.sleep(20000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
               ExtentReportManager.flush();
            //DriverManager.getDriver().quit();
    }
}
