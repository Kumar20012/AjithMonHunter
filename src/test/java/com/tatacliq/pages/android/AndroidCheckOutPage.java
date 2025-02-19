package com.tatacliq.pages.android;

import com.tatacliq.pages.ui.CheckOutPage;
import org.apache.commons.collections4.functors.WhileClosure;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidCheckOutPage extends AndroidBasePage implements CheckOutPage {


    @FindBy(id = "com.tul.tatacliq:id/toolbar_title")
    WebElement checkoutText;


    @FindBy(id = "com.tul.tatacliq:id/button_my_bag_checkout")
    WebElement payNowButton;


    @Override
    public boolean verifyUserOnCheckOutPage() {
        return checkoutText.isDisplayed();
    }

    @Override
    public boolean verifyPayNowButton() {
        return payNowButton.isDisplayed();
    }
}
