package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidProductPage;
import com.tatacliq.pages.ui.ProductPage;
import com.tatacliq.pages.web.WebProductPage;
import com.tatacliq.utils.ConfigurationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductPageSteps extends BaseSteps {

    @Then("verify user on product page")
    public void verifyUserOnProductPage() {
        Assert.assertTrue(productPage.verifyUserOnProductPage());
    }

    @Then("display the product details")
    public void displayTheProductDetails() {
        productPage.displayProductDetails();
    }

    @And("the user can select filter option {string}")
    public void theUserCanSelectFilterOption(String option) {
        productPage.selectFilterOption(option);
    }

    @And("user select the {string} brand")
    public void userSelectTheBrand(String brandName) {
        productPage.userSelectBrandName(brandName);
    }

    @When("the user clicks on a product that contains the keyword {string}")
    public void theUserClicksOnAProductThatContainsTheKeyword(String keyword) {
        productPage.userClickProductContainKeyword(keyword);
    }

    @And("the user selects the Sort by option and chooses {string}")
    public void theUserSelectsTheSortByOptionAndChooses(String option) {
        productPage.userSelectSortOption(option);
    }

    @Then("verify all listed products are sorted by popularity")
    public void verifyAllListedProductsAreSortedByPopularity() {
        Assert.assertTrue(productPage.isProductSortedByPopularity());
    }

    @Then("verify all listed products are displayed in ascending order price")
    public void verifyAllListedProductsAreDisplayedInAscendingOrderPrice() {
        Assert.assertTrue(productPage.isPriceSortedLowToHigh());
    }

    @Then("verify all listed products are displayed in descending order price")
    public void verifyAllListedProductsAreDisplayedInDescendingOrderPrice() {
        Assert.assertTrue(productPage.isPriceSortedHighToLow());
    }

    @Then("verify all listed products are displayed based on new arrival")
    public void verifyAllListedProductsAreDisplayedBasedOnNewArrival() {
        Assert.assertTrue(productPage.isProductSortedByNewArrival());
    }

    @Then("verify user should see product prices sorted by discounts")
    public void verifyUserShouldSeeProductPricesSortedByDiscounts() {
        Assert.assertTrue(productPage.isProductSortedByDiscount());
    }
}
