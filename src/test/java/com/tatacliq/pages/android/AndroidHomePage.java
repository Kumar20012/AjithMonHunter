package com.tatacliq.pages.android;

import com.tatacliq.pages.ui.HomePage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidHomePage extends AndroidBasePage implements HomePage {

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"My Account\"]")
    WebElement myAccount;

    @FindBy(xpath="//android.widget.FrameLayout[@content-desc=\"Login\"]")
    WebElement loginBtn;

    @FindBy(id = "com.tul.tatacliq:id/rl_tv_prominent")
    WebElement searchBar;

    @FindBy(id = "android:id/search_src_text")
    WebElement searchText;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.tul.tatacliq:id/suggestSearch\"]")
    List<WebElement> listOfProduct;

    String x_path = "//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.tul.tatacliq:id/composeNewHome\"]/android.view.View/android.view.View[3]/android.view.View[%s]";

    @FindBy(id="com.tul.tatacliq:id/closeButton")
    WebElement closeBtn;

    public void userOpenApplication(String val){
        WebElement category = driver.findElement(By.xpath(String.format(x_path,val)));
        category.click();
        closeBtn.click();
    }


    public boolean verifyUserOnHomePage(){
        return searchBar.isDisplayed();
    }

     public void clickOnLoginButton(){
        loginBtn.click();
    }

    public void userEnterSearchProduct(String productName){
        searchBar.click();
        searchText.sendKeys(productName);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}
