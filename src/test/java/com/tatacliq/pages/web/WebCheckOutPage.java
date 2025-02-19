package com.tatacliq.pages.web;

import com.tatacliq.pages.ui.CheckOutPage;
import org.hamcrest.Factory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebCheckOutPage extends WebBasePage implements CheckOutPage {
    @FindBy(className = "CheckOutPage__checkoutHeader")
    WebElement pageTitle;

    @FindBy(xpath = "//span[text()='Netbanking']/following-sibling::div[@class='MenuDetails__icon']")
    WebElement netBankOption;

    @FindBy(className = "BankSelect__image")
    WebElement selectBankBtn;

    @FindBy(xpath = "//div[@class='NetBanking__buttonHolder']/div")
    WebElement payNowBtn;

    @Override
    public boolean verifyUserOnCheckOutPage() {
        return pageTitle.isDisplayed();
    }

    @Override
    public boolean verifyPayNowButton() {
        click(netBankOption);
        click(selectBankBtn);
        return payNowBtn.isEnabled();
    }
}
