package com.tatacliq.pages.android;

import com.tatacliq.pages.ui.ProductPage;
import com.tatacliq.utils.ConfigurationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidProductPage extends AndroidBasePage implements ProductPage {

    @FindBy(id = "com.tul.tatacliq:id/textViewRefine")
    WebElement filterIcon;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.tul.tatacliq:id/textViewProductName']")
    List<WebElement> listOfProduct;

    @FindBy(id = "com.tul.tatacliq:id/textViewProductSP")
    List<WebElement> listOfPrice;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.tul.tatacliq:id/txtShowResults']")
    WebElement showResultButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.tul.tatacliq:id/textViewFilterValueName']")
    List<WebElement> listOfBrand;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.tul.tatacliq:id/emptyText']")
    WebElement noProduct;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.tul.tatacliq:id/textViewProductBrand']")
    List<WebElement> ProductList;

    @FindBy(id = "com.tul.tatacliq:id/sortView")
    WebElement sortByOption;

    @FindBy(id = "com.tul.tatacliq:id/textViewSortApplied")
    WebElement popularityVerify;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.tul.tatacliq:id/badgeTextView']")
    WebElement newArrivalVerify;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.tul.tatacliq:id/textViewProductSP']")
    List<WebElement> priceList;

    @FindBy(id = "com.tul.tatacliq:id/text_discount")
    List<WebElement> productDiscount;

    @FindBy(id = "com.tul.tatacliq:id/sortBack")
    WebElement sortBack;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.tul.tatacliq:id/imageViewAddToWishListGrid']")
    WebElement wishListBtn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Wish List']")
    WebElement wishListIcon;

    String xpath_sort = "//android.widget.TextView[@text='%s']";

    String x_path_filter = "//android.widget.TextView[@resource-id='com.tul.tatacliq:id/txtFilterKey' and @text='%s']";

    @Override
    public boolean verifyUserOnProductPage() {
        return filterIcon.isDisplayed();
    }

    @Override
    public void displayProductDetails() {
        for (WebElement pro : listOfProduct) {
            System.out.println("Product Name : " + pro.getText());
            for (WebElement price : listOfPrice) {
                System.out.println("Product Price : " + price.getText());
            }
        }
    }

    @Override
    public void selectFilterOption(String option) {
        filterIcon.click();
        WebElement ele = driver.findElement(By.xpath(String.format(x_path_filter, option)));
        ele.click();
    }

    @Override
    public void userSelectBrandName(String brandName) {
        for (WebElement pro : listOfBrand) {
            if (pro.getText().equals(brandName)) {
                pro.click();
                break;
            }
        }
        showResultButton.click();
    }

    @Override
    public void userClickOneProduct() {
        priceList.getFirst().click();
    }

    @Override
    public void userClickProductContainKeyword(String keyword) {
        while (!isDisplayedCheck(noProduct)) {
            for (WebElement ele : ProductList) {
                if (ele.getText().contains(keyword)) {
                    ele.click();
                    return;
                }
            }
            scrollPage();
            ProductList = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.tul.tatacliq:id/textViewProductBrand']"));
        }
    }

    @Override
    public void userSelectSortOption(String option) {
        sortByOption.click();
        driver.findElement(By.xpath(String.format(xpath_sort, option))).click();
    }

    @Override
    public boolean isProductSortedByPopularity() {
        sortBack.click();
        return popularityVerify.isDisplayed();
    }

    @Override
    public boolean isPriceSortedLowToHigh() {
        for (int i = 0; i < priceList.size(); i++) {
            String price1 = priceList.get(i).getText().replaceAll("[^0-9]", "");
            String price2 = priceList.get(i + 1).getText().replaceAll("[^0-9]", "");
            if (Integer.parseInt(price1) < Integer.parseInt(price2)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isPriceSortedHighToLow() {
        for (int i = 0; i < priceList.size(); i++) {
            String price1 = priceList.get(i).getText().replaceAll("[^0-9]", "");
            String price2 = priceList.get(i + 1).getText().replaceAll("[^0-9]", "");
            if (Integer.parseInt(price1) > Integer.parseInt(price2)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductSortedByNewArrival() {
        return newArrivalVerify.isDisplayed();
    }

    @Override
    public boolean isProductSortedByDiscount() {
        for (WebElement ele : productDiscount) {
            String price = ele.getText().replaceAll("[^0-9]", "");
            if (Integer.parseInt(price) > 80) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void userClickWishListBtn() {
        ConfigurationManager.setConfigValue("first.brand", priceList.getFirst().getText());
        wishListBtn.click();
        wishListIcon.click();
    }
}
