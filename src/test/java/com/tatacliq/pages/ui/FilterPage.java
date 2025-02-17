package com.tatacliq.pages.ui;

public interface FilterPage {
    void userSelectBrandName(String brandName);
    void selectFilterOption(String option);
    boolean verifyUserOnFilterPage();

    void userClickSearchButton();
}
