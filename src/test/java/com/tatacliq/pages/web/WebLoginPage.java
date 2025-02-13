package com.tatacliq.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebLoginPage extends WebBasePage{
    @FindBy(id="mobileNumber")
    WebElement numberInputBar;

    @FindBy(id="continueBtn")
    WebElement continueBtn;

    @FindBy(xpath = "//button[@class='mobile-number-login__btnPrimary']")
    WebElement otpContinueBtn;

    @FindBy(xpath = "//div[@class='mobile-number-login__lognSucess_TxtSec']")
    WebElement successMsg;

    public boolean verifyUserOnLoginPage(){
        return numberInputBar.isDisplayed();
    }
    public void userEnterMobileNumber(String number){
        numberInputBar.click();
        numberInputBar.sendKeys(number);
    }
    public void userClickContinueButton() {
        continueBtn.click();
    }
    public void fillOtp(){
        while (!otpContinueBtn.isDisplayed()) {
            System.out.println("waiting for otp");
        }
        otpContinueBtn.click();
    }

    public boolean isSuccessMessageDisplayed(){
        return successMsg.isDisplayed();
    }


}
