package com.tatacliq.pages.android;

import com.tatacliq.pages.ui.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidProductPage extends AndroidBasePage implements ProductPage {

    @FindBy(id="com.tul.tatacliq:id/textViewRefine")
    WebElement filterIcon;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.tul.tatacliq:id/textViewProductName\"]")
    List<WebElement> listOfProduct;

    @FindBy(id = "com.tul.tatacliq:id/textViewProductSP")
    List<WebElement> listOfPrice;


    @FindBy(xpath="//android.widget.TextView[@resource-id=\"com.tul.tatacliq:id/txtShowResults\"]")
    WebElement showResultButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.tul.tatacliq:id/textViewFilterValueName\"]")
    List<WebElement> listOfBrand;

    String x_path_filter="//android.widget.TextView[@resource-id=\"com.tul.tatacliq:id/txtFilterKey\" and @text='%s']";

    public boolean verifyUserOnProductPage(){
        return filterIcon.isDisplayed();
    }


    public void displayProductDetails(){
        for(WebElement pro : listOfProduct){
            System.out.println("Product Name : "+pro.getText());
            for(WebElement price: listOfPrice){
                System.out.println("Product Price : "+price.getText());
            }
        }
    }


    public void selectFilterOption(String option){
        filterIcon.click();
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
        showResultButton.click();
    }
}
