package com.tatacliq.pages.web;

import com.tatacliq.pages.ui.LoginPage;
import com.tatacliq.pages.ui.ProductPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class WebLoginPage extends WebBasePage implements LoginPage {
    @FindBy(id = "mobileNumber")
    WebElement numberInputBar;

    @FindBy(id = "continueBtn")
    WebElement continueBtn;

    @FindBy(xpath = "//button[@class='mobile-number-login__btnPrimary']")
    WebElement otpContinueBtn;

    @Override
    public boolean verifyUserOnLoginPage() {
        return numberInputBar.isDisplayed();
    }

    @Override
    public void userEnterMobileNumber(String number) {
        numberInputBar.click();
        numberInputBar.sendKeys(number);
    }

    @Override
    public boolean checkContinueButton() {
        return continueBtn.isEnabled();
    }

    @Override
    public void userClickContinueButton() {
        continueBtn.click();
        pause(15);
        while (!otpContinueBtn.isEnabled()) {
            System.out.println("waiting for otp");
        }
        otpContinueBtn.click();
    }

}
