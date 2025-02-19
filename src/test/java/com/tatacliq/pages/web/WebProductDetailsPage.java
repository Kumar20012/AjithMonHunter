package com.tatacliq.pages.web;

import com.tatacliq.pages.ui.ProductDetailsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebProductDetailsPage extends WebBasePage implements ProductDetailsPage {

     @FindBy(xpath = "//span[text()='BUY NOW']")
     WebElement buyNowBtn ;

     @FindBy(xpath = "//span[text()='ADD TO BAG']")
     WebElement addToBagBtn;

     @FindBy(xpath = "//div[@class='DesktopHeader__myBagShow']/span")
     WebElement cartQty;

     @FindBy(className = "DesktopHeader__myBagShow")
     WebElement cartBtn;

    @Override
    public boolean verifyUserOnProductDetailsPage() {
        return addToBagBtn.isDisplayed();
    }

    @Override
    public void ClickOnAddToBagButton() {
        click(addToBagBtn);
    }

    @Override
    public boolean verifyTheItemAddedToMyBag() {
        return cartQty.getText().equals("1");
    }

    @Override
    public void userClickOnMYBagIcon() {
        pause(5);
        click(cartBtn);
    }
}
