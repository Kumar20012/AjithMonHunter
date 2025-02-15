package com.tatacliq.pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidFilterPage extends AndroidBasePage{

    @FindBy(xpath="//android.widget.TextView[@resource-id=\"com.tul.tatacliq:id/txtShowResults\"]")
    WebElement showResultButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.tul.tatacliq:id/textViewFilterValueName\"]")
    List<WebElement> listOfBrand;

    String x_path_filter="//android.widget.TextView[@resource-id=\"com.tul.tatacliq:id/txtFilterKey\" and @text='%s']";

    public boolean verifyUserOnFilterPage(){
        return showResultButton.isDisplayed();
    }

    public void selectFilterOption(String option){
        WebElement ele = driver.findElement(By.xpath(String.format(x_path_filter,option)));
        ele.click();
    }

    public void userSelectBrandName(String brandName) {
        for(WebElement pro:listOfBrand){
            if(pro.getText().equals(brandName)){
                pro.click();
                break;
            }
        }
    }

    public void userClickSearchButton(){
        showResultButton.click();
    }
}
