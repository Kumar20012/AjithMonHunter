package com.tatacliq.pages.android;

import com.tatacliq.pages.ui.MyBagPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidMyBagPage extends AndroidBasePage implements MyBagPage {

    @FindBy(id = "com.tul.tatacliq:id/button_my_bag_checkout")
    WebElement checkOutButton;

    @FindBy(id = "com.tul.tatacliq:id/txtMyBagCouponCode")
    WebElement checkCoupon;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Type pincode here\"]")
    WebElement pinCodeBar;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Submit\"]")
    WebElement submitButton;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View")
    WebElement addressDetailBox;

    @Override
    public boolean verifyUserOnMyBagPage() {
        return checkOutButton.isDisplayed();
    }

    @Override
    public void userClickCoupon() {
        checkCoupon.click();
    }

    @Override
    public void userClickCheckOutButton() {
        checkOutButton.click();
    }

    @Override
    public void userEnterPinCodeDeliver(String pinCode) {
        pause(3);
        pinCodeBar.click();
        pause(3);
        driver.findElement(By.xpath("//android.widget.EditText")).sendKeys(pinCode);
        submitButton.click();
        checkOutButton.click();
    }


}
