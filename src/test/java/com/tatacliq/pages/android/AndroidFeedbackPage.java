package com.tatacliq.pages.android;

import com.tatacliq.pages.ui.FeedbackPage;
import com.tatacliq.utils.ConfigurationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidFeedbackPage extends AndroidBasePage implements FeedbackPage {

    @FindBy(id = "com.tul.tatacliq:id/tv_submit")
    WebElement submitBtn;

    @FindBy(id = "com.tul.tatacliq:id/comments_textbox")
    WebElement textBox;

    @FindBy(id = "com.tul.tatacliq:id/button_saveAndExit")
    WebElement exitBtn;

    String RATING_XPATH = "(//android.widget.ImageView[@resource-id='com.tul.tatacliq:id/iv_emoji_%s'])";

    @Override
    public boolean isFeedbackPageDisplayed() {
        return submitBtn.isDisplayed();
    }

    @Override
    public void userFillRatings() {
        for (int i = 1; i <= 5; i++) {
            String ratingXpath = String.format(RATING_XPATH, ConfigurationManager.getConfigValues("rate.star")) + "[" + i + "]";
            WebElement rate = driver.findElement(By.xpath(ratingXpath));
            rate.click();
        }
    }

    @Override
    public void userFillFeedback() {
        scrollPage();
        textBox.sendKeys(ConfigurationManager.getConfigValues("fill.feedback"));
    }

    @Override
    public void userClickSubmitButton() {
        submitBtn.click();
    }

}
