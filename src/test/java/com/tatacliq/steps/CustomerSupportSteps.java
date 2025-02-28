package com.tatacliq.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CustomerSupportSteps extends BaseSteps {

    @Then("verify user is on customer support page")
    public void verify_user_is_on_customer_support_page() {
        Assert.assertTrue(customerPage.isCustomerPageDisplayed());
    }

    @Then("verify contact us option is displayed")
    public void verify_contact_us_option_is_displayed() {
        Assert.assertTrue(customerPage.isContactUsBtnDisplayed());
    }

    @When("user click on contact us button")
    public void user_click_on_contact_us_button() {
        customerPage.clickOnContactUsBtn();
    }

    @When("user select the raise a complaint option")
    public void user_select_the_raise_a_complaint_option() {
        customerPage.userSelectComplaintOption();
    }

    @Then("verify the ticket raising tab is displayed")
    public void verify_the_ticket_raising_tab_is_displayed() {
        Assert.assertTrue(customerPage.isFillingTabDisplayed());
    }

    @When("user fill the details about issue and click next Button")
    public void user_fill_the_details_about_issue_and_click_next_button() {
        customerPage.userFillProblemDetails();
    }

    @When("user upload the attachment on particular issue and submit")
    public void user_upload_the_attachment_on_particular_issue_and_submit() {
        customerPage.uploadAttachment();
    }

    @Then("verify user can submit the complaint successfully")
    public void verify_user_can_submit_the_complaint_successfully() {
        Assert.assertTrue(customerPage.verifyUserCanSubmitComplaint());
    }

    @When("user select issue type {string} and submit")
    public void userSelectIssueTypeAndSubmit(String value) {
        customerPage.userSelectIssueType(value);
    }

    @When("user select issue type {string}")
    public void userSelectIssueType(String value) {
        customerPage.userSelectIssueType(value);
    }

    @And("user select various options {string} from suggestions")
    public void userSelectVariousOptionsFromSuggestions(String value) {
        customerPage.userSelectVariousTicketOptions(value);
    }
}
