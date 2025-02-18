package com.tatacliq.pages.android;

import com.tatacliq.pages.ui.CheckOutPage;
import org.apache.commons.collections4.functors.WhileClosure;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidCheckOutPage extends AndroidBasePage implements CheckOutPage {


    @FindBy(id = "com.tul.tatacliq:id/toolbar_title")
    WebElement checkoutText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.tul.tatacliq:id/text_view_payment_method\" and @text=\"UPI\"]")
    WebElement upiOption;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.tul.tatacliq:id/image_view_expend_payment_method\"])[2]")
    WebElement upiArrow;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.tul.tatacliq:id/ivUPIAppLogo\"])[1]")
    WebElement googlePayLogo;

    @FindBy(id = "com.tul.tatacliq:id/button_my_bag_checkout")
    WebElement payNowButton;


    @Override
    public boolean verifyUserOnCheckOutPage() {
        return checkoutText.isDisplayed();
    }

    @Override
    public boolean verifyPayNowButton() {
        while (isDisplayedCheck(upiOption)){
            scrollPage();
        }
        upiArrow.click();
        googlePayLogo.click();
        return payNowButton.isDisplayed();
    }
}
