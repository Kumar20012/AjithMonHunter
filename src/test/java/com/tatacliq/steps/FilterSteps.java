package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidFilterPage;
import com.tatacliq.pages.web.WebProductPage;
import com.tatacliq.utils.ConfigurationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class FilterSteps  {
    WebProductPage webProductPage;
    AndroidFilterPage filterPage;

    FilterSteps(){
     if(ConfigurationManager.getConfigValues("application.type").equals("web")){
         webProductPage = new WebProductPage();
        }
     else {
         filterPage = new AndroidFilterPage();
     }
    }

    @Then("verify the user on filter page")
    public void verifyTheUserOnFilterPage() {
        Assert.assertTrue(androidFilterPage.verifyUserOnFilterPage());
    }

    @And("the user can select filter option {string}")
    public void theUserCanSelectFilterOption(String option) {
        if(ConfigurationManager.getConfigValues("application.type").equals("web")){
            webProductPage.selectFilterOption(option);
        }
        else{
            androidFilterPage.selectFilterOption(option);
        }
    }

    @And("user select the {string} brand")
    public void userSelectTheBrand(String brandName) {
        if(ConfigurationManager.getConfigValues("application.type").equals("web")){
            webProductPage.userSelectBrandName(brandName);
        }
        else{
            androidFilterPage.userSelectBrandName(brandName);
        }
    }

    @And("user click the search result")
    public void userClickTheSearchResult() {
        androidFilterPage.userClickSearchButton();
    }
}
