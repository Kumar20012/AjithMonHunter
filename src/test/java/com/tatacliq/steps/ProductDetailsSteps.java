package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidHomePage;
import com.tatacliq.pages.android.AndroidProductDetailsPage;
import com.tatacliq.pages.ui.ProductDetailsPage;
import com.tatacliq.pages.web.WebHomePage;
import com.tatacliq.utils.ConfigurationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductDetailsSteps extends BaseSteps {

    @Then("verify the user should be on the product details page")
    public void verify_the_user_should_be_on_the_product_details_page() {
        Assert.assertTrue(productDetailsPage.verifyUserOnProductDetailsPage());
    }

    @When("the user clicks the add to bag button")
    public void the_user_clicks_the_add_to_bag_button() {
        productDetailsPage.ClickOnAddToBagButton();
    }

    @Then("verify the item should be added to the bag")
    public void the_item_should_be_added_to_the_bag() {
        Assert.assertTrue(productDetailsPage.verifyTheItemAddedToMyBag());
    }

    @When("the user clicks on the My Bag icon")
    public void the_user_clicks_on_the_my_bag_icon() {
        productDetailsPage.userClickOnMYBagIcon();
    }

    @When("user click on feedback button")
    public void userClickOnFeedbackButton() {
        productDetailsPage.clickOnFeedbackButton();
    }

}
