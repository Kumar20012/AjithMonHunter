package com.tatacliq.pages.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AndroidHomePage extends AndroidBasePage{

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"My Account\"]")
    WebElement myAccount;

    @FindBy(id = "com.tul.tatacliq:id/rl_tv_prominent")
    WebElement searchBar;


    public boolean verifyUserOnHomePage(){
        return myAccount.isDisplayed() && searchBar.isDisplayed();
    }
}
