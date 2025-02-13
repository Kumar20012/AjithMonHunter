package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidHomePage;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageSteps {
    AndroidHomePage androidHomePage= new AndroidHomePage();


    @And("verify user on home page")
    public void verifyUserOnHomePage() {
        Assert.assertTrue(androidHomePage.verifyUserOnHomePage());
    }
}
