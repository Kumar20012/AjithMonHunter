package com.tatacliq.pages.web;

import com.tatacliq.pages.ui.MyBagPage;
import com.tatacliq.utils.ConfigurationManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebMyBagPage extends WebBasePage implements MyBagPage {

    @FindBy(xpath = "//span[text()='Checkout']")
    WebElement checkoutBtn;

    @FindBy(className = "Coupon__apply")
    WebElement applyCouponBtn;

    @FindBy(xpath = "//span[text()='Deliver Here']")
    WebElement deliverBtn;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//input[@class='AddressItem__unselectedRadio']")
    WebElement addressSelectBtn;

    @Override
    public boolean verifyUserOnMyBagPage() {
        return checkoutBtn.isDisplayed();
    }

    @Override
    public void userClickCoupon() {
        applyCouponBtn.click();
    }

    @Override
    public void userClickCheckOutButton() {
        checkoutBtn.click();
    }

    @Override
    public void userEnterPinCodeDeliver(String pinCode) {
        addressSelectBtn.click();
        deliverBtn.click();
        checkoutBtn.click();
    }
}
