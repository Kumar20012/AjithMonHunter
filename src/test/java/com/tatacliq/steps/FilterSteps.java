package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidFilterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class FilterSteps {

    AndroidFilterPage androidFilterPage = new AndroidFilterPage();

    @Then("verify the user on filter page")
    public void verifyTheUserOnFilterPage() {
        Assert.assertTrue(androidFilterPage.verifyUserOnFilterPage());
    }

    @And("the user can select filter option {string}")
    public void theUserCanSelectFilterOption(String option) {
        androidFilterPage.selectFilterOption(option);
    }

    @And("user select the {string} brand")
    public void userSelectTheBrand(String brandName) {
        androidFilterPage.userSelectBrandName(brandName);
    }

    @And("user click the search result")
    public void userClickTheSearchResult() {
        androidFilterPage.userClickSearchButton();
    }
}
