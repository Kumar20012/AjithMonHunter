package com.tatacliq.pages.ui;

public interface HomePage {
    boolean verifyUserOnHomePage();

    void clickOnLoginButton();

    void userEnterSearchProduct(String productName);

    void userOpenApplication(String val);

    default void userClickMyAccountIcon(){

    };

    void userClickLogoutButton();

    void navigateAddressInput();

    void userFillAddressDetails(String PIN, String firstname, String lastname, String address, String number);

    void displayAddressDetails();

    void userClickAddressSubmit();

    void clickOnCustomerCareBtn();


}
