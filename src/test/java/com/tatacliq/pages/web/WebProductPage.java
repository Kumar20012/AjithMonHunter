package com.tatacliq.pages.web;

import com.tatacliq.pages.ui.ProductPage;
import com.tatacliq.utils.ConfigurationManager;
import com.tatacliq.utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebProductPage extends WebBasePage implements ProductPage {

    @FindBy(xpath = "//div[text()='Filters']")
    WebElement filterIcon;

    @FindBy(xpath = "//select[@class='SelectBoxDesktop__hideSelect']")
    WebElement selectFilter;

    @FindBy(xpath = "//div[@class='ProductModule__base']//div[@class='ProductDescription__content']/h2")
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

    @FindBy(className = "SelectBoxDesktop__hideSelect")
    WebElement sortByBtn;

    @FindBy(className = "SelectBoxDesktop__visibleBoxWithLeftChild")
    WebElement finalSortValue;

    @FindBy(className = "ProductModule__base")
    List<WebElement> dummyProductList;

    @FindBy(xpath = "//div[@class=\"ProductModule__dummyDiv\"]")
    List<WebElement> productFrame;

    @FindBy(xpath = "//div[@class='Plp__icon']//div/div")
    WebElement expandButton;


    public boolean verifyUserOnProductPage() {
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

    public void userClickProductContainKeyword(String keyword){
        for(WebElement ele:dummyProductList){
            if(ele.findElement(By.xpath(".//div[@class='ProductDescription__content']/h2")).getText().contains(keyword)){
                ele.click();
                switchToSecondWindow(driver);
                return;
            }
        }

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

    public void userSelectSortOption(String option) {
        Select select = new Select(sortByBtn);
        select.selectByVisibleText(option);
        ConfigurationManager.setConfigValue("sorted.option", option);
    }

    public boolean isProductSortedByPopularity(){
        return finalSortValue.getText().equals(ConfigurationManager.getConfigValues("sorted.option"));
    }

    public boolean isPriceSortedHighToLow() {
        for (int i = 0; i < listOfPrice.size(); i++) {
            String element = listOfPrice.get(i).getText().replaceAll("[^0-9]", "");
            String element1 = listOfPrice.get(i + 1).getText().replaceAll("[^0-9]", "");
            return Integer.parseInt(element) > Integer.parseInt(element1);
        }
        return false;
    }

    public boolean isPriceSortedLowToHigh() {
        for (int i = 0; i < listOfPrice.size(); i++) {
            String element = listOfPrice.get(i).getText().replaceAll("[^0-9]", "");
            String element1 = listOfPrice.get(i + 1).getText().replaceAll("[^0-9]", "");
            return Integer.parseInt(element) < Integer.parseInt(element1);
        }
        return false;
    }
    public boolean isProductSortedByNewArrival(){
        pause(3);
        for(WebElement ele:dummyProductList){
            WebElement tag=ele.findElement(By.xpath(".//div[@class='ProductModule__flagHolder']/div"));
            if(tag.getText().contains("New Arrivals") || tag.getText().contains("New")){
                return true;
            }
        }
        return false;
    }
    public boolean isProductSortedByDiscount(){
        pause(3);
        for(WebElement ele:dummyProductList){
            WebElement tag=ele.findElement(By.xpath(".//span[@class='ProductDescription__newDiscountPercent']"));
            String value=tag.getText().replaceAll("[^0-9]","");
            if(Integer.parseInt(value) > 75){
                return true;
            }
        }
        return false;
    }
    public  void userClickOneProduct(){
        click(listOfProduct.getFirst());
        switchToSecondWindow(driver);
    }


    public Map<String, Integer> userClickExpandBtn(){
        Dimension dimensions = productFrame.get(1).getSize();
        int width = dimensions.getWidth();
        int height = dimensions.getHeight();

        expandButton.click();

        Dimension dimensions1 = productFrame.get(1).getSize();
        int width1= dimensions1.getWidth();
        int height1 = dimensions1.getHeight();

        Map<String, Integer> dimensionData = new HashMap<>();
        dimensionData.put("oldWidth", width);
        dimensionData.put("oldHeight", height);
        dimensionData.put("newWidth", width1);
        dimensionData.put("newHeight", height1);

        return dimensionData;
    }

    public boolean verifyExpandButton(){
        Map<String, Integer> dimensions = userClickExpandBtn();
        int oldWidth = dimensions.get("oldWidth");
        int oldHeight = dimensions.get("oldHeight");
        int newWidth = dimensions.get("newWidth");
        int newHeight = dimensions.get("newHeight");
        return (newWidth< oldWidth) && (newHeight<oldHeight) && (newWidth==203) && (newHeight==444);
    }

}
