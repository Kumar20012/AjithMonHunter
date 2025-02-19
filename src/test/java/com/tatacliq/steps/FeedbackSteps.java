package com.tatacliq.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FeedbackSteps extends BaseSteps{
    @Then("verify user is on feedback page")
    public void verify_user_is_on_feedback_page() {
      Assert.assertTrue( feedbackPage.isFeedbackPageDisplayed());
    }

    @When("user fill ratings from feedback page")
    public void user_fill_ratings_from_feedback_page() {
       feedbackPage.userFillRatings();
    }

    @When("user enter feedback about product")
    public void user_enter_feedback_about_product() {
        feedbackPage.userFillFeedback();
    }

    @When("user click on submit feedback button")
    public void user_click_on_submit_feedback_button() {
       feedbackPage.userClickSubmitButton();
    }

    @Then("verify user submitted feedback successfully")
    public void verify_user_submitted_feedback_successfully() {
       Assert.assertTrue(productDetailsPage.verifyUserOnProductDetailsPage());
    }


}
