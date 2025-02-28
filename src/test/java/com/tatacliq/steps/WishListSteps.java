package com.tatacliq.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WishListSteps extends BaseSteps {

    @Then("verify product added in wish list successfully")
    public void verify_product_added_in_wish_list_successfully() {
        Assert.assertTrue(wishListPage.isProductAddedInWishList());
    }

    @When("user delete the product from wish list")
    public void user_delete_the_product_from_wish_list() {
        wishListPage.deleteProductFromWishList();
    }

    @Then("verify product deleted from wish list successfully")
    public void verify_product_deleted_from_wish_list_successfully() {
        Assert.assertTrue(wishListPage.isProductDeletedSuccessfully());
    }
}
