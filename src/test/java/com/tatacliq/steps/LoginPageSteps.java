package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidHomePage;
import com.tatacliq.pages.android.AndroidLoginPage;
import com.tatacliq.pages.ui.HomePage;
import com.tatacliq.pages.ui.LoginPage;
import com.tatacliq.pages.web.WebHomePage;
import com.tatacliq.pages.web.WebLoginPage;
import com.tatacliq.utils.ConfigurationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps extends BaseSteps {

    @When("user enter phone number {string}")
    public void user_enter_phone_number(String number)  {
        loginPage.userEnterMobileNumber(ConfigurationManager.getConfigValues(number));
    }

    @Then("click continue button")
    public void click_continue_button() {
        loginPage.userClickContinueButton();
    }

    @Then("verify the number is valid")
    public void verifyTheNumberIsValid() {
        Assert.assertTrue(loginPage.checkContinueButton());
    }

    @Then("verify the number is Invalid")
    public void verifyTheNumberIsInvalid() {
        Assert.assertFalse(loginPage.checkContinueButton());
    }

    @Then("verify user on login page")
    public void verifyUserOnLoginPage() {
        Assert.assertTrue(loginPage.verifyUserOnLoginPage());
    }


    @When("user fill invalid numbers {string}")
    public void userFillInvalidNumbers(String number) {
        loginPage.userEnterMobileNumber(number);
    }

}
