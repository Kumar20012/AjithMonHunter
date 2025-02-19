package com.tatacliq.pages.web;

import com.tatacliq.pages.ui.CouponPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebCouponPage extends WebBasePage implements CouponPage {

    @FindBy(className = "SlideModal__cancel")
    WebElement closeCouponBtn;

    @FindBy(className = "CuponDetails__applyCoupon")
    WebElement applyBtn;

    @Override
    public boolean verifyUserOnCouponPage() {
        return closeCouponBtn.isDisplayed();
    }

    @Override
    public void userApplyCoupon() {
        if (applyBtn.isDisplayed()) {
            applyBtn.click();
        }
        closeCouponBtn.click();
    }
}
