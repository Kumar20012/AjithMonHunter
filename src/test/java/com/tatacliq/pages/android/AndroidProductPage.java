package com.tatacliq.pages.android;

import com.tatacliq.pages.ui.ProductPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidProductPage extends AndroidBasePage implements ProductPage {

    @FindBy(id="com.tul.tatacliq:id/textViewRefine")
    WebElement filterIcon;

    public boolean verifyUserOnProductPage(){
        return filterIcon.isDisplayed();
    }

}
