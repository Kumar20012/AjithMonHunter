package com.tatacliq.pages.ui;

public interface ProductPage {

    boolean verifyUserOnProductPage();

    void displayProductDetails();

    void userSelectBrandName(String brandName);
    void selectFilterOption(String option);

    void userClickProductContainKeyword(String keyword);
    void userSelectSortOption(String option);
    boolean isProductSortedByPopularity();
    boolean isPriceSortedHighToLow();
    boolean isPriceSortedLowToHigh();
    boolean isProductSortedByNewArrival();
    boolean isProductSortedByDiscount();
    void userClickOneProduct();
}
