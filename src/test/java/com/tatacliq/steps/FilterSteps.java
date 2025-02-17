package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidFilterPage;
import com.tatacliq.pages.ui.FilterPage;
import com.tatacliq.utils.ConfigurationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class FilterSteps {

    FilterPage filterPage;

    public FilterSteps(){
        if(ConfigurationManager.getConfigValues("application.type").equals("web")){
            filterPage=new WebFilterPage();
        }
        else{
           filterPage=new AndroidFilterPage();
        }
    }

    @Then("verify the user on filter page")
    public void verifyTheUserOnFilterPage() {
        Assert.assertTrue(filterPage.verifyUserOnFilterPage());
    }

    @And("the user can select filter option {string}")
    public void theUserCanSelectFilterOption(String option) {
        filterPage.selectFilterOption(option);
    }

    @And("user select the {string} brand")
    public void userSelectTheBrand(String brandName) {
        filterPage.userSelectBrandName(brandName);
    }

    @And("user click the search result")
    public void userClickTheSearchResult() {
        filterPage.userClickSearchButton();
    }
}
