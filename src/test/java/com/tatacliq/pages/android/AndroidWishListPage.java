package com.tatacliq.pages.android;

import com.tatacliq.pages.ui.WishListPage;
import com.tatacliq.utils.ConfigurationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidWishListPage extends AndroidBasePage implements WishListPage {
    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View")
    List<WebElement>wishListItems;
    @FindBy(xpath = "//android.view.View[@content-desc=\"remove\"]")
    List<WebElement> deleteBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Continue Shopping']")
    WebElement continueShopBtn;

    public boolean isProductAddedInWishList(){
        for(WebElement ele:wishListItems){;
            if(ele.findElement(By.xpath(".//android.view.View/android.widget.TextView")).getText().equals(ConfigurationManager.getConfigValues("first.brand"))){
                return true;
            }
        }
        return !wishListItems.isEmpty();
    }
    public void deleteProductFromWishList(){
        for (WebElement ele:deleteBtn){
            ele.click();
        }
    }
    public boolean isProductDeletedSuccessfully() {
    return wishListItems.isEmpty();
    }

}
