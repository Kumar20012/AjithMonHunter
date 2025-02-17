package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidProductPage;
import com.tatacliq.pages.ui.ProductPage;
import com.tatacliq.pages.web.WebProductPage;
import com.tatacliq.utils.ConfigurationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductPageSteps {

    ProductPage productPage;

    public ProductPageSteps(){
        if(ConfigurationManager.getConfigValues("application.type").equals("web")){
           productPage=new WebProductPage();
        }
        else{
            productPage=new AndroidProductPage();
        }
    }


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

}
