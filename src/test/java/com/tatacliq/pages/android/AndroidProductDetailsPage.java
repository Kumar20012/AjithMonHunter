package com.tatacliq.pages.android;

import com.tatacliq.pages.ui.ProductDetailsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidProductDetailsPage extends AndroidBasePage implements ProductDetailsPage {


    @FindBy(id = "com.tul.tatacliq:id/textViewAddToCart")
    WebElement addToBagButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"My Bag\" and @resource-id=\"com.tul.tatacliq:id/view\"]")
    WebElement myBagIcon;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.tul.tatacliq:id/cartBadge\"]")
    WebElement bagValue;

    @FindBy(id="com.tul.tatacliq:id/appCompatTextView2")
    WebElement feedbackBtn;

    @Override
    public boolean verifyUserOnProductDetailsPage() {
        return  addToBagButton.isDisplayed();
    }

    @Override
    public void ClickOnAddToBagButton() {
        addToBagButton.click();
    }

    @Override
    public boolean verifyTheItemAddedToMyBag() {
        return bagValue.getText().equals("1");
    }

    @Override
    public void userClickOnMYBagIcon() {
        myBagIcon.click();
    }

    public void clickOnFeedbackButton(){
        while (!isDisplayedCheck(feedbackBtn)){
            scrollPage();
        }
        feedbackBtn.click();
    }
}
