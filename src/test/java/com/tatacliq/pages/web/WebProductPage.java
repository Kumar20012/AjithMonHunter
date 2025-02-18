package com.tatacliq.pages.web;

import com.tatacliq.pages.ui.ProductPage;
import com.tatacliq.utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WebProductPage extends WebBasePage implements ProductPage {

    @FindBy(xpath = "//div[text()='Filters']")
    WebElement filterIcon;

    @FindBy(xpath = "//select[@class='SelectBoxDesktop__hideSelect']")
    WebElement selectFilter;

    @FindBy(xpath = "//div[@class='ProductDescription__content']/h2")
    List<WebElement> listOfProduct;

    @FindBy(xpath = "//div[@class='ProductDescription__discount ProductDescription__priceHolder']/h3")
    List<WebElement> listOfPrice;

    @FindBy(id = "Filter-clearAllCTA")
    WebElement clearFilter;

    String x_path_filter = "//div[text()='%s']//following-sibling::div";

    @FindBy(className = "FilterSelect__data")
    List<WebElement> listOfBrand;

    @FindBy(xpath = "//input[@placeholder='Search by brands']")
    WebElement searchBrand;


    public boolean verifyUserOnProductPage(){
        return filterIcon.isDisplayed();
    }


    public void displayProductDetails() {
        List<List<String>> productData = new ArrayList<>();
        for (int i = 0; i < listOfProduct.size(); i++) {
            String title = listOfProduct.get(i).getText();
            String price = listOfPrice.get(i).getText();
            ExcelUtils.addProductData(productData, title, price);
        }
        String filePath = "ProductDetails.xlsx";
        ExcelUtils.writeDataToExcel(productData, filePath);
    }



    public void selectFilterOption(String option) {
        WebElement ele = driver.findElement(By.xpath(String.format(x_path_filter, option)));
        ele.click();
    }

    @Override
    public void userClickProductContainKeyword(String keyword) {

    }

    public void userSelectBrandName(String brandName) {
        searchBrand.sendKeys(brandName);
        for (WebElement pro : listOfBrand) {
            if (pro.getText().equals(brandName)) {
                pro.click();
                break;
            }
        }
        pause(5);
    }

}
