package com.tatacliq.pages.android;

import com.tatacliq.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidBasePage {

    static AppiumDriver driver;
    WebDriverWait wait;
    AndroidBasePage(){
        driver = (AppiumDriver) DriverManager.getDriver();
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
