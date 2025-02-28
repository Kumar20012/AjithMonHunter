package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidHomePage;
import com.tatacliq.pages.ui.HomePage;
import com.tatacliq.pages.web.WebHomePage;
import com.tatacliq.utils.ConfigurationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class HomePageSteps extends BaseSteps{

    @Given("user open application {string}")
    public void userOpenApplication(String category) {
        homePage.userOpenApplication(ConfigurationManager.getConfigValues(category));
    }

    @And("verify user on home page")
    public void verifyUserOnHomePage() {
        Assert.assertTrue(homePage.verifyUserOnHomePage());
    }

    @When("user click login button")
    public void userClickLoginButton() {
        homePage.clickOnLoginButton();
    }


    @When("user enter search product {string}")
    public void userEnterSearchProduct(String product) {
        homePage.userEnterSearchProduct(ConfigurationManager.getConfigValues(product));
    }

    @When("user click my account icon")
    public void userClickMyAccountIcon() {
        homePage.userClickMyAccountIcon();
    }

    @Then("user click on logout button")
    public void userClickOnLogoutButton() {
        homePage.userClickLogoutButton();
    }

    @And("user navigate to the address input page")
    public void iNavigateToTheAddressInputPage() {
        homePage.navigateAddressInput();
    }

    @When("user enter {string}, {string}, {string}, {string}, {string}")
    public void userEnter(String PIN, String firstname, String lastname, String address, String number) {
        homePage.userFillAddressDetails(PIN,firstname,lastname, address,  number);
    }

    @And("user submit the address form")
    public void iSubmitTheAddressForm() {
        homePage.userClickAddressSubmit();
    }

    @Then("before adding the details display the existing address details")
    public void beforeAddingTheDetailsDisplayTheExistingAddressDetails() {
        homePage.displayAddressDetails();
    }

    @And("user click on customer care button")
    public void user_click_on_customer_care_button() {
        homePage.clickOnCustomerCareBtn();
    }

}
