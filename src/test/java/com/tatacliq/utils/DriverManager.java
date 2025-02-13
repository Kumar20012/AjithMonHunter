package com.tatacliq.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverManager {

    static WebDriver driver;

    public static void createDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName",ConfigurationManager.getConfigValues("device.name"));
        capabilities.setCapability("app",System.getProperty("user.dir") + ConfigurationManager.getConfigValues("app.path"));
        capabilities.setCapability("automationName",ConfigurationManager.getConfigValues("automation.name"));
        capabilities.setCapability("platformName",ConfigurationManager.getConfigValues("platform.name"));
        driver = new AndroidDriver(capabilities);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
