package com.tatacliq.pages.android;

import com.tatacliq.pages.ui.MyBagPage;
import com.tatacliq.utils.ConfigurationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidMyBagPage extends AndroidBasePage implements MyBagPage {

    @FindBy(id = "com.tul.tatacliq:id/button_my_bag_checkout")
    WebElement checkOutButton;

    @FindBy(id = "com.tul.tatacliq:id/txtMyBagCouponCode")
    WebElement checkCoupon;

    @FindBy(xpath = "//android.widget.TextView[@text='Type pincode here']")
    WebElement pinCodeBar;

    @FindBy(xpath = "//android.widget.TextView[@text='Submit']")
    WebElement submitButton;

    @FindBy(id = "com.tul.tatacliq:id/text_view_remove_product")
    WebElement removeButton;

    @FindBy(xpath = "//android.widget.ImageButton")
    WebElement backArrows;

    @FindBy(id = "com.tul.tatacliq:id/normalCartLayout")
    WebElement productLayout;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.tul.tatacliq:id/itemTitle' and @text='Bag Total']/following-sibling::android.widget.TextView")
    WebElement bagTotal;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.tul.tatacliq:id/processingValue']")
    WebElement processFee;

    @FindBy(id = "com.tul.tatacliq:id/text_quantity")
    WebElement qtyArrow;

    @FindBy(xpath = "//android.widget.TextView[@text='Done']")
    WebElement doneBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.tul.tatacliq:id/itemTitle' and @text='Total Payable']/following-sibling::android.widget.TextView")
    WebElement total;

    String QTY_XPATH = "//android.widget.TextView[@text='%s']";

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

    @Override
    public void removeMyBagProducts() {
        if (isDisplayedCheck(removeButton)) {
            removeButton.click();
        }
        backArrows.click();
    }

    @Override
    public void userIncreaseQuantity(String quantity) {
        scroll(productLayout);
        ConfigurationManager.setConfigValue("product.price", bagTotal.getText());
        ConfigurationManager.setConfigValue("product.processingfees", processFee.getText());
        qtyArrow.click();
        WebElement qty = driver.findElement(By.xpath(String.format(QTY_XPATH, quantity)));
        qty.click();
        doneBtn.click();
        pause(3);
    }

    @Override
    public boolean verifyProductPrice() {
        String productPrice = ConfigurationManager.getConfigValues("product.price");
        productPrice = productPrice.replaceAll("[^0-9.]", "");
        String process = ConfigurationManager.getConfigValues("product.processingfees");
        process = process.replaceAll("[^0-9.]", "");
        String quantity = ConfigurationManager.getConfigValues("product.quantity");
        String expected = total.getText().replaceAll("[^0-9.]", "");
        int product_price = (int) Double.parseDouble(productPrice);
        int process_fees = (int) Double.parseDouble(process);
        int qty = Integer.parseInt(quantity);
        int expected_price = (int) Double.parseDouble(expected);
        int actualPrice = (product_price * qty) + process_fees;
        return expected_price == actualPrice;
    }


}
