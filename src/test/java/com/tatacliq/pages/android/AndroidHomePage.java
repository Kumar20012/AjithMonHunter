package com.tatacliq.pages.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AndroidHomePage extends AndroidBasePage{

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"My Account\"]")
    WebElement myAccount;

    @FindBy(id = "com.tul.tatacliq:id/rl_tv_prominent")
    WebElement searchBar;

    @FindBy(id = "android:id/search_src_text")
    WebElement searchText;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.tul.tatacliq:id/suggestSearch\"]")
    List<WebElement> listOfProduct;


    public boolean verifyUserOnHomePage(){
        return myAccount.isDisplayed() && searchBar.isDisplayed();
    }

    public void userEnterSearchProduct(String productName){
        searchBar.click();
        searchText.sendKeys(productName);
        listOfProduct.get(1).click();
    }
}
