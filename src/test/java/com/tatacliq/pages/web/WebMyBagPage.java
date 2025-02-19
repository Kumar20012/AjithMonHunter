package com.tatacliq.pages.web;

import com.tatacliq.pages.ui.MyBagPage;
import com.tatacliq.utils.ConfigurationManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebMyBagPage extends WebBasePage implements MyBagPage {

    @FindBy(xpath = "//span[text()='Checkout']")
    WebElement checkoutBtn;

    @FindBy(xpath = "//div[@class='Coupon__apply']/div/div")
    WebElement applyCouponBtn;

    @FindBy(xpath = "//span[text()='Deliver Here']")
    WebElement deliverBtn;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submitBtn;

    @FindBy(className = "CartItemForDesktop__removeLabelForCartPage")
    WebElement removeButton;

    @FindBy(xpath = "//input[@class='AddressItem__unselectedRadio']")
    WebElement addressSelectBtn;

    @FindBy(xpath = "//span[text()='Continue Shopping']")
    WebElement continueShoppingBtn;

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
        pause(2);
        addressSelectBtn.click();
        deliverBtn.click();
        pause(2);
        checkoutBtn.click();
    }

    @Override
    public void removeMyBagProducts() {
        if(removeButton.isDisplayed()){
            click(removeButton);
            continueShoppingBtn.click();
        }
        continueShoppingBtn.click();
    }
}
