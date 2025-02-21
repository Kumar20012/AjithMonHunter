package com.tatacliq.pages.web;

import com.tatacliq.pages.ui.MyBagPage;
import com.tatacliq.utils.ConfigurationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "//div[text()='Qty']/following-sibling::div")
    WebElement qtyArrow;

    @FindBy(xpath = "//div[@class='SizeSelector__quantityGrid']/div")
    List<WebElement> quantityValue;

    @FindBy(xpath = "//span[text()='Done']")
    WebElement doneButton;

    @FindBy(xpath = "//div[text()='Bag Total']/following-sibling::div")
    WebElement productPrice;

    @FindBy(className = "DesktopCheckout__shippingCharge")
    WebElement processingFees;


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

    @Override
    public void userIncreaseQuantity(String quantity) {
        ConfigurationManager.setConfigValue("product.price",productPrice.getText());
        String val = processingFees.getAttribute("innerText");
        String firstValue = val.split("\\s+")[1];
        ConfigurationManager.setConfigValue("product.processingfees",firstValue);
        qtyArrow.click();
        for(WebElement ele : quantityValue){
            if(ele.getText().equals(quantity)){
                ele.click();
                break;
            }
        }
        doneButton.click();

    }

    @Override
    public void verifyProductPrice() {
        String productPrice = ConfigurationManager.getConfigValues("product.price");
        productPrice = productPrice.replaceAll("[^0-9.]","");
        String process = ConfigurationManager.getConfigValues("product.processingfees");
        process = process.replaceAll("[^0-9.]","");
        String quantity = ConfigurationManager.getConfigValues("product.quantity");
        String expected= driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
        expected = expected.replaceAll("[^0-9.]","");
        int product_price =(int) Double.parseDouble(productPrice);
        int  process_fees =(int) Double.parseDouble(process);
        int qty = Integer.parseInt(quantity);
        int expected_price = (int)Double.parseDouble(expected);
        int actualPrice = (product_price * qty)+process_fees;
        System.out.println(product_price);
        System.out.println(process_fees);
        System.out.println(qty);
        System.out.println(expected_price);
        System.out.println(actualPrice);
    }
}
