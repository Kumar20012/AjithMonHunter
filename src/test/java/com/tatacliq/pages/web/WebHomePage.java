package com.tatacliq.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebHomePage extends WebBasePage{

    @FindBy(id="search-text-input")
    WebElement searchBar;

    @FindBy(xpath = "//div[text()='Sign in / Sign Up']")
    WebElement signUpBtn;

    @FindBy(xpath = "//span[text()='Login/ Register']")
    WebElement loginBtn;

    @FindBy(id = "wzrk-cancel")
    WebElement askLater;

    public boolean verifyUserOnHomePage(){
        return  searchBar.isDisplayed();
    }

    public void clickOnLoginButton(){
        moveToElement(signUpBtn);
        loginBtn.click();
    }



}
