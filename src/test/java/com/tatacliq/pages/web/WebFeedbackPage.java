package com.tatacliq.pages.web;

import com.tatacliq.pages.ui.FeedbackPage;
import com.tatacliq.utils.ConfigurationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebFeedbackPage extends WebBasePage implements FeedbackPage {

    @FindBy(className = "FeedbackExperienceForm__next_box")
    WebElement nextBtn;

    @FindBy(className = "FeedbackExperienceForm__feedback_box")
    WebElement textBar;

    @FindBy(className = "FeedbackExperienceForm__submit_box")
    WebElement submitBtn;

    @FindBy(className = "ContinueFeedback__exitAndSubmitButton")
    WebElement exitBtn;

    String RATING_XPATH="(//div[contains(@class ,'FeedbackExperienceForm__emojis_imgClass FeedbackExperienceForm__emoji_%s FeedbackExperienceForm__emoji')])";

    @Override
    public boolean isFeedbackPageDisplayed() {
        return nextBtn.isDisplayed();
    }

    @Override
    public void userFillRatings() {
        for (int i = 1; i <= 4; i++) {
            String ratingXpath = String.format(RATING_XPATH, ConfigurationManager.getConfigValues("rate.star")) + "[" + i + "]";
            WebElement rate = driver.findElement(By.xpath(ratingXpath));
            rate.click();
        }
        nextBtn.click();
    }

    @Override
    public void userFillFeedback() {
        textBar.sendKeys(ConfigurationManager.getConfigValues("fill.feedback"));
    }

    @Override
    public void userClickSubmitButton() {
        submitBtn.click();
        exitBtn.click();
    }
}
