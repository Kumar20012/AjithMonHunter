package com.tatacliq.pages.android;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}
