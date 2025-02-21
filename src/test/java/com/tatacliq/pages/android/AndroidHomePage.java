package com.tatacliq.pages.android;

import com.tatacliq.pages.ui.HomePage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AndroidHomePage extends AndroidBasePage implements HomePage {

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"My Account\"]")
    WebElement myAccount;

    @FindBy(xpath="//android.widget.FrameLayout[@content-desc=\"Login\"]")
    WebElement loginBtn;

    @FindBy(id = "com.tul.tatacliq:id/tvProminentSearch")
    WebElement searchBar;

    @FindBy(id = "android:id/search_src_text")
    WebElement searchText;

    @FindBy(id = "com.tul.tatacliq:id/txtLogout")
    WebElement logoutArrow;

    @FindBy(id = "com.tul.tatacliq:id/btnLogout")
    WebElement logoutButton;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.tul.tatacliq:id/composeNewHome\"]/android.view.View/android.view.View[3]/android.view.View[2]")
    WebElement welcomePageVerify;

    String x_path = "//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.tul.tatacliq:id/composeNewHome\"]/android.view.View/android.view.View[3]/android.view.View[%s]";

    @FindBy(id="com.tul.tatacliq:id/closeButton")
    WebElement closeBtn;

    @FindBy(id="com.tul.tatacliq:id/txtAddressBook")
    WebElement addressBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Add Shipping Address']")
    WebElement addDetailsBtn;

    @FindBy(id = "com.tul.tatacliq:id/edtfirstName")
    WebElement firstName;
    @FindBy(id = "com.tul.tatacliq:id/edtLastName")
    WebElement lastName;
    @FindBy(id = "com.tul.tatacliq:id/edtAddress")
    WebElement addressType;
    @FindBy(id = "com.tul.tatacliq:id/edtPincode")
    WebElement enterPIN;
    @FindBy(id = "com.tul.tatacliq:id/edtPhoneNumber")
    WebElement phoneNumber;
    @FindBy(id = "com.tul.tatacliq:id/btnSave")
    WebElement saveBtn;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.TextView")
    List<WebElement>addressList;

    public void userOpenApplication(String val){
        WebElement category = driver.findElement(By.xpath(String.format(x_path,val)));
        category.click();
        closeBtn.click();
    }


    public boolean verifyUserOnHomePage() {
        try {
            return searchBar.isDisplayed();
        } catch (RuntimeException e) {
            return welcomePageVerify.isDisplayed();
        }
    }

     public void clickOnLoginButton(){
        loginBtn.click();
    }

    public void userEnterSearchProduct(String productName){
        pause(10);
        searchBar.click();
        searchText.sendKeys(productName);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void userClickMyAccountIcon(){
        myAccount.click();
    }

    public void userClickLogoutButton(){
        logoutArrow.click();
        pause(3);
        while (!isDisplayedCheck(logoutButton)){
            scrollPage();
        }
        logoutButton.click();
    }

    @Override
    public void navigateAddressInput() {
        addressBtn.click();
    }

    @Override
    public void userFillAddressDetails(String PIN, String firstname, String lastname, String address, String number) {
        firstName.click();
        firstName.sendKeys(firstname);
        lastName.click();
        lastName.sendKeys(lastname);
        scroll(lastName);
        addressType.click();
        addressType.sendKeys(address);
        scroll(addressType);
        enterPIN.click();
        enterPIN.sendKeys(PIN);
        while (!isDisplayedCheck(phoneNumber)){
            scroll(enterPIN);
        }
        phoneNumber.click();
        phoneNumber.sendKeys(number);
    }

    @Override
    public void displayAddressDetails() {
        for(WebElement data : addressList){
            System.out.println(data.getText());
        }
        addDetailsBtn.click();
    }

    @Override
    public void userClickAddressSubmit() {
        saveBtn.click();
    }

}
