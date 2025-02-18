package com.tatacliq.pages.android;

import com.tatacliq.pages.ui.CouponPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidCouponPage extends AndroidBasePage implements CouponPage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.tul.tatacliq:id/txtApply\"]")
    WebElement applyButton;

    @FindBy(xpath = "//android.widget.ImageButton")
    WebElement backButton;

    @Override
    public boolean verifyUserOnCouponPage() {
        return backButton.isDisplayed();
    }

    @Override
    public void userApplyCoupon() {
        if(applyButton.isDisplayed()){
            applyButton.click();
        }
        else{
            System.out.println("No Coupons Available");
            backButton.click();
        }
    }
}
