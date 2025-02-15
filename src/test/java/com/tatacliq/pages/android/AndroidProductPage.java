package com.tatacliq.pages.android;

import com.tatacliq.pages.ui.ProductPage;
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

    public boolean verifyUserOnProductPage(){
        return filterIcon.isDisplayed();
    }

    public void userSelectFilterOption(){
        filterIcon.click();
    }

    public void displayProductDetails(){
        for(WebElement pro : listOfProduct){
            System.out.println("Product Name : "+pro.getText());
            for(WebElement price: listOfPrice){
                System.out.println("Product Price : "+price.getText());
            }
        }
    }
}
