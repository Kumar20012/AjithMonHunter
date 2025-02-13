package com.tatacliq.pages.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidProductPage extends AndroidBasePage{

    @FindBy(id="com.tul.tatacliq:id/textViewRefine")
    WebElement filterIcon;

    public boolean verifyUserOnProductPage(){
        return filterIcon.isDisplayed();
    }

}
