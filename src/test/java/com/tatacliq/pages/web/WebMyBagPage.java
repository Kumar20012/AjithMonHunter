package com.tatacliq.pages.web;

import com.tatacliq.pages.ui.MyBagPage;
import com.tatacliq.utils.ConfigurationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebMyBagPage extends WebBasePage implements MyBagPage {

    @FindBy(xpath = "//span[text()='Checkout']")
    WebElement checkoutBtn;

    @FindBy(xpath = "//div[@class='Coupon__apply']/div/div")
    WebElement applyCouponBtn;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submitBtn;

    @FindBy(className = "CartItemForDesktop__removeLabelForCartPage")
    WebElement removeButton;


    @FindBy(xpath = "//span[contains(text(), 'Continue Shopping')]/..")
    WebElement continueShoppingBtn;

    @FindBy(xpath = "//span[contains(text(), 'Continue Shopping')]")
    WebElement ele;

    @FindBy(xpath = "//input[@placeholder=\"Type Pincode Here\"]")
    WebElement textBar;


    @Override
    public boolean verifyUserOnMyBagPage() {
        return checkoutBtn.isDisplayed();
    }

    @Override
    public void userClickCoupon() {
        click(applyCouponBtn);
        pause(5);
    }

    @Override
    public void userClickCheckOutButton() {
        click(checkoutBtn);
    }

    @Override
    public void userEnterPinCodeDeliver(String pinCode) {
        pause(5);
        textBar.click();
        textBar.sendKeys(pinCode);
        submitBtn.click();
        checkoutBtn.click();
    }

    @Override
    public void removeMyBagProducts() {
        if(isDisplayedCheck(ele)){
            continueShoppingBtn.click();
        }
        else{
            removeButton.click();
            continueShoppingBtn.click();
        }
    }
}
