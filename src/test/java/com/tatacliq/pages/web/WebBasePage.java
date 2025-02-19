package com.tatacliq.pages.web;

import com.tatacliq.utils.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

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

    public  void switchToWindow(){
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        for(String window : allWindow){
            if(!window.equals(currentWindow)){
                driver.switchTo().window(window);
            }
        }

    }

    protected void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            executor.executeScript("arguments[0].click();", element);
        }
    }

    protected void waitTillVisible(WebElement ele) {
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public static void switchToSecondWindow(WebDriver driver) {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public static void switchToOriginalWindow(WebDriver driver) {
        String currentWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(currentWindowHandle);
    }

    protected void moveToElement(WebElement ele) {
        actions.moveToElement(ele).build().perform();
    }

    public void pause(int sec){
        try {
            Thread.sleep(Duration.ofSeconds(sec).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
