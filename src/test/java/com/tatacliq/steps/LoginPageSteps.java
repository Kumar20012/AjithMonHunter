package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidLoginPage;
import com.tatacliq.utils.ConfigurationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

    AndroidLoginPage androidLoginPage = new AndroidLoginPage();

    @When("user enter phone number {string}")
    public void user_enter_phone_number(String number) {
        androidLoginPage.userEnterMobileNumber(ConfigurationManager.getConfigValues(number));
    }

    @Then("click continue button")
    public void click_continue_button() {
     androidLoginPage.userClickContinueButton();
    }

    @Then("verify the number is valid")
    public void verifyTheNumberIsValid() {
        Assert.assertTrue(androidLoginPage.verifyValidPhoneNumber());
    }

    @Then("verify the number is Invalid")
    public void verifyTheNumberIsInvalid() {
        Assert.assertFalse(androidLoginPage.verifyValidPhoneNumber());
    }

    @Then("verify user on login page")
    public void verifyUserOnLoginPage() {
    }

    @And("fill the otp and click submit")
    public void fillTheOtpAndClickSubmit() {

    }
    @Then("verify success message displayed")
    public void verifySuccessMessageDisplayed() {
    }

    @When("user fill invalid numbers {string}")
    public void userFillInvalidNumbers(String arg0) {
        
    }

    @Then("verify user can not login successfully")
    public void verifyUserCanNotLoginSuccessfully() {
    }
}
