package com.tatacliq.pages.web;

import com.tatacliq.utils.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebBasePage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor executor;
    Actions actions;

    public WebBasePage() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        executor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    protected void moveToElement(WebElement ele) {
        actions.moveToElement(ele).build().perform();
    }
}
