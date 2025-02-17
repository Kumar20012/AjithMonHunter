package com.tatacliq.pages.android;

import com.tatacliq.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidBasePage {

    static AndroidDriver driver;
    WebDriverWait wait;
    AndroidBasePage(){
        driver = (AndroidDriver) DriverManager.getDriver();
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void pause(int sec){
        try {
            Thread.sleep(Duration.ofSeconds(sec).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
