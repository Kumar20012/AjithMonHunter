package com.tatacliq.pages.ui;

public interface HomePage {
    boolean verifyUserOnHomePage();
    void clickOnLoginButton();
    void userEnterSearchProduct(String productName);
    void userOpenApplication(String val);
    void userClickMyAccountIcon();
    void userClickLogoutButton();
}
