package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidMyBagPage;
import com.tatacliq.pages.ui.MyBagPage;
import com.tatacliq.pages.web.WebMyBagPage;
import com.tatacliq.utils.ConfigurationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyBagSteps {

    MyBagPage myBagPage;

    public MyBagSteps() {
        if (ConfigurationManager.getConfigValues("application.type").equals("web")) {
            myBagPage=new WebMyBagPage();
        } else {
            myBagPage = new AndroidMyBagPage();
        }
    }

    @Then("verify the user should be on the My Bag page")
    public void verify_the_user_should_be_on_the_my_bag_page() {
        Assert.assertTrue(myBagPage.verifyUserOnMyBagPage());
    }

    @When("the user clicks on the Coupon option")
    public void the_user_clicks_on_the_coupon_option() {
        myBagPage.userClickCoupon();
    }

    @When("the user clicks the checkout button")
    public void the_user_clicks_the_checkout_button() {
        myBagPage.userClickCheckOutButton();
    }

    @And("user fill delivery address details {string}")
    public void userFillDeliveryAddressDetails(String pinCode) {
        myBagPage.userEnterPinCodeDeliver(ConfigurationManager.getConfigValues(pinCode));
    }
}
