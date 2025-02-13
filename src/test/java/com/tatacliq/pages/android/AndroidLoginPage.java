package com.tatacliq.pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AndroidLoginPage extends AndroidBasePage{

    @FindBy(id = "com.tul.tatacliq:id/editTextMobileNumber")
    WebElement numberBar;

    @FindBy(id = "com.tul.tatacliq:id/btContinueJoin")
    WebElement continueButton;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    WebElement allowButton;

    @FindBy(id= "com.tul.tatacliq:id/cancel_button")
    WebElement fingerprintSkip;


    public boolean verifyUserOnLoginPage(){
        return numberBar.isDisplayed();
    }

    public void userEnterMobileNumber(String number){
        numberBar.click();
        if(!continueButton.isEnabled()){
            numberBar.sendKeys(number);
        }
    }

    public void userClickContinueButton(){
        continueButton.click();
        allowButton.click();
        wait.until(ExpectedConditions.visibilityOf(fingerprintSkip));
        fingerprintSkip.click();
    }


}
