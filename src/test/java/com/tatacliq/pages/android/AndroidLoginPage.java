package com.tatacliq.pages.android;

import com.tatacliq.pages.ui.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AndroidLoginPage extends AndroidBasePage implements LoginPage {

    @FindBy(id = "com.tul.tatacliq:id/editTextMobileNumber")
    WebElement numberBar;

    @FindBy(id = "com.tul.tatacliq:id/btContinueJoin")
    WebElement continueButton;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    WebElement allowButton;

    @FindBy(id = "com.tul.tatacliq:id/cancel_button")
    WebElement fingerprintSkip;

    @Override
    public boolean verifyUserOnLoginPage() {
        return numberBar.isDisplayed();
    }

    @Override
    public void userEnterMobileNumber(String number) {
        numberBar.click();
        if (!continueButton.isEnabled()) {
            numberBar.sendKeys(number);
        }
    }

    @Override
    public boolean checkContinueButton() {
        return continueButton.isEnabled();
    }

    @Override
    public void userClickContinueButton() {
        continueButton.click();
        allowButton.click();
        wait.until(ExpectedConditions.visibilityOf(fingerprintSkip));
        fingerprintSkip.click();
    }


}
