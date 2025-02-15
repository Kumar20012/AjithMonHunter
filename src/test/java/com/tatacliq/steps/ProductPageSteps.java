package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductPageSteps {

    AndroidProductPage androidProductPage =new AndroidProductPage();

    @Then("verify user on product page")
    public void verifyUserOnProductPage() {
        Assert.assertTrue(androidProductPage.verifyUserOnProductPage());
    }

    @When("the user click filter button")
    public void theUserSelectFilterOption() {
        androidProductPage.userSelectFilterOption();
    }

    @Then("display the product details")
    public void displayTheProductDetails() {
        androidProductPage.displayProductDetails();
    }
}
