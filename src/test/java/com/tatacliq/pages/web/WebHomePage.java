package com.tatacliq.pages.web;

import com.tatacliq.pages.ui.HomePage;
import com.tatacliq.utils.ConfigurationManager;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebHomePage extends WebBasePage implements HomePage {

    @FindBy(id="search-text-input")
    WebElement searchBar;

    @FindBy(xpath = "//div[text()='Sign in / Sign Up']")
    WebElement signUpBtn;

    @FindBy(xpath = "//span[text()='Login/ Register']")
    WebElement loginBtn;

    @FindBy(id = "wzrk-cancel")
    WebElement askLater;

    @FindBy(className = "DesktopHeader__iconPersonHolder")
    WebElement myProfile;

    @FindBy(className = "LogoutButton__menuIconLogOut")
    WebElement logoutBtn;

    public void userOpenApplication(String val) {
        driver.get(ConfigurationManager.getConfigValues("application.url"));
        askLater.click();
    }

    public boolean verifyUserOnHomePage(){
        return searchBar.isDisplayed();
    }

    public void clickOnLoginButton(){
        signUpBtn.click();
    }


    public void userEnterSearchProduct(String productName){
        pause(5);
        searchBar.click();
        searchBar.sendKeys(productName+Keys.ENTER);
    }



}
