package com.tatacliq.pages.web;

import com.tatacliq.pages.ui.FilterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileFilter;
import java.util.List;


public class WebFilterPage extends WebBasePage implements FilterPage {

    @FindBy(id = "Filter-clearAllCTA")
    WebElement clearFilter;

    String x_path_filter = "//div[text()='%s']//following-sibling::div";

    @FindBy(className = "FilterSelect__data")
    List<WebElement> listOfBrand;

    @FindBy(xpath = "//input[@placeholder='Search by brands']")
    WebElement searchBrand;

    public boolean verifyUserOnFilterPage() {
        return clearFilter.isDisplayed();
    }

    public void selectFilterOption(String option) {
        WebElement ele = driver.findElement(By.xpath(String.format(x_path_filter, option)));
        ele.click();
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
    public void userClickSearchButton(){

    }
}
