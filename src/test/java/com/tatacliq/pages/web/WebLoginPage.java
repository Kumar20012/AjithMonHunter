package com.tatacliq.pages.web;

import com.tatacliq.pages.ui.LoginPage;
import com.tatacliq.pages.ui.ProductPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class WebLoginPage extends WebBasePage implements LoginPage{
    @FindBy(id="mobileNumber")
    WebElement numberInputBar;

    @FindBy(id="continueBtn")
    WebElement continueBtn;

    @FindBy(xpath = "//button[@class='mobile-number-login__btnPrimary']")
    WebElement otpContinueBtn;


    public boolean verifyUserOnLoginPage(){
        return numberInputBar.isDisplayed();
    }
    public void userEnterMobileNumber(String number) {
        numberInputBar.click();
        numberInputBar.sendKeys(number);
    }

    public boolean checkContinueButton(){
        return continueBtn.isEnabled();
    }


    public void userClickContinueButton() {
        continueBtn.click();
        pause(5);
        while (!otpContinueBtn.isEnabled()) {
            System.out.println("waiting for otp");
        }
        otpContinueBtn.click();
    }

}
