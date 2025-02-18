package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidCouponPage;
import com.tatacliq.pages.android.AndroidMyBagPage;
import com.tatacliq.pages.ui.CouponPage;
import com.tatacliq.pages.ui.MyBagPage;
import com.tatacliq.utils.ConfigurationManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CouponPageSteps
{
    CouponPage couponPage;

    public CouponPageSteps() {
        if (ConfigurationManager.getConfigValues("application.type").equals("web")) {
            //productDetailsPage= new WebProductDeatilsPage();
        } else {
            couponPage = new AndroidCouponPage();
        }
    }
    @Then("verify the user should be on the coupon page")
    public void verify_the_user_should_be_on_the_coupon_page() {
        Assert.assertTrue(couponPage.verifyUserOnCouponPage());
    }
    @When("a valid coupon is available, the user applies it")
    public void a_valid_coupon_is_available_the_user_applies_it() {
        couponPage.userApplyCoupon();
    }
}
