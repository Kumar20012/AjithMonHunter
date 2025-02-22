package com.tatacliq.steps;

import com.tatacliq.pages.android.*;
import com.tatacliq.pages.ui.*;
import com.tatacliq.pages.web.*;
import com.tatacliq.utils.ConfigurationManager;

public class BaseSteps {
    CheckOutPage checkOutPage;
    CouponPage couponPage;
    HomePage homePage;
    LoginPage loginPage;
    MyBagPage myBagPage;
    ProductDetailsPage productDetailsPage;
    ProductPage productPage;
    FeedbackPage feedbackPage;
    WishListPage wishListPage;
    CustomerPage customerPage;

    public BaseSteps(){
        if (ConfigurationManager.getConfigValues("application.type").equals("web")) {
            checkOutPage = new WebCheckOutPage();
            couponPage = new WebCouponPage();
            homePage = new WebHomePage();
            loginPage =new WebLoginPage();
            myBagPage = new WebMyBagPage();
            productPage = new WebProductPage();
            productDetailsPage= new WebProductDetailsPage();
            feedbackPage=new WebFeedbackPage();
        } else {
            checkOutPage = new AndroidCheckOutPage();
            couponPage = new AndroidCouponPage();
            homePage = new AndroidHomePage();
            loginPage =new AndroidLoginPage();
            myBagPage = new AndroidMyBagPage();
            productPage = new AndroidProductPage();
            productDetailsPage= new AndroidProductDetailsPage();
            feedbackPage=new AndroidFeedbackPage();
            wishListPage=new AndroidWishListPage();
            customerPage=new AndroidCustomerPage();
        }
    }


}
