package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidWelcomePage;
import com.tatacliq.utils.ConfigurationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WelcomePageSteps {
    AndroidWelcomePage androidWelcomePage = new AndroidWelcomePage();

    @Given("user open application")
    public void user_open_application() {

    }
    @When("user click the  category {string}")
    public void user_click_the_category(String category) {
        androidWelcomePage.userOpenApplicationAndSelectCategory(ConfigurationManager.getConfigValues(category));
    }

}
