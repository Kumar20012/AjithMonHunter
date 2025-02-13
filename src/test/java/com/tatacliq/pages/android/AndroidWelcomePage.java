package com.tatacliq.pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidWelcomePage extends AndroidBasePage{

    String x_path = "//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.tul.tatacliq:id/composeNewHome\"]/android.view.View/android.view.View[3]/android.view.View[%s]";

    public void userOpenApplicationAndSelectCategory(String val){
        WebElement category = driver.findElement(By.xpath(String.format(x_path,val)));
        category.click();
    }

}
