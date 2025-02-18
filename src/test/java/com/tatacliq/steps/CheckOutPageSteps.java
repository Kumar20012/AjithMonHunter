package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidCheckOutPage;
import com.tatacliq.pages.android.AndroidCouponPage;
import com.tatacliq.pages.ui.CheckOutPage;
import com.tatacliq.pages.ui.CouponPage;
import com.tatacliq.utils.ConfigurationManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckOutPageSteps {

    CheckOutPage checkOutPage;

    public CheckOutPageSteps() {
        if (ConfigurationManager.getConfigValues("application.type").equals("web")) {
            //productDetailsPage= new WebProductDeatilsPage();
        } else {
            checkOutPage = new AndroidCheckOutPage();
        }
    }

    @Then("verify the user should be on the checkout page")
    public void verify_the_user_should_be_on_the_checkout_page() {
        Assert.assertTrue(checkOutPage.verifyUserOnCheckOutPage());
    }
    @Then("the user verify pay now button should be available for completing the purchase")
    public void the_user_verify_pay_now_button_should_be_available_for_completing_the_purchase() {
       Assert.assertTrue(checkOutPage.verifyPayNowButton());
    }
}
