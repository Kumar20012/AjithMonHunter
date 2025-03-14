package com.tatacliq.pages.ui;

public interface MyBagPage {
    boolean verifyUserOnMyBagPage();

    void userClickCoupon();

    void userClickCheckOutButton();

    void userEnterPinCodeDeliver(String pinCode);

    void removeMyBagProducts();

    void userIncreaseQuantity(String quantity);

    boolean verifyProductPrice();
}
