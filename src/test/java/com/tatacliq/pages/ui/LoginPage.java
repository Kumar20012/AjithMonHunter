package com.tatacliq.pages.ui;

public interface LoginPage {

    boolean verifyUserOnLoginPage();

    boolean checkContinueButton();

     void userEnterMobileNumber(String number) ;

    void userClickContinueButton();

}
