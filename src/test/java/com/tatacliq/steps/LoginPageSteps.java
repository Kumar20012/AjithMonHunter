package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidLoginPage;
import com.tatacliq.utils.ConfigurationManager;
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
}
