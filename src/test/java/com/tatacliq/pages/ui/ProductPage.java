package com.tatacliq.pages.ui;

import java.util.HashMap;
import java.util.Map;

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

    default void userClickWishListBtn() {
    }

    default Map<String, Integer> userClickExpandBtn(){
        return new HashMap<>();
    };

    default boolean verifyExpandButton(){
        return true;
    };
}
