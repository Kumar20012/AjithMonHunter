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


public class HomePageSteps {

    HomePage homePage;

    public HomePageSteps(){
        if(ConfigurationManager.getConfigValues("application.type").equals("web")){
            homePage = new WebHomePage();
        }
        else{
            homePage = new AndroidHomePage();
        }
    }


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

}
