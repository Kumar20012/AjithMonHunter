package com.tatacliq.pages.web;

import com.tatacliq.pages.ui.HomePage;
import com.tatacliq.utils.ConfigurationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebHomePage extends WebBasePage implements HomePage {

    @FindBy(id="search-text-input")
    WebElement searchBar;

    @FindBy(xpath = "//div[text()='Sign in / Sign Up']")
    WebElement signUpBtn;

    @FindBy(xpath = "//div[text()='Address Book']")
    WebElement addressButton;

    @FindBy(xpath = "//span[contains(text(), 'Add a new address')]/..")
    WebElement newAddressAdd;

    @FindBy(xpath = "//input[@placeholder='Enter your PIN code*']")
    WebElement enterPIN;

    @FindBy(xpath = "//input[@placeholder='First Name*']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name*']")
    WebElement lastName;

    @FindBy(xpath = "//div[@class=\"TextArea__container\"]/textarea")
    WebElement addressType;

    @FindBy(xpath = "//input[@placeholder='Phone number(Required)*']")
    WebElement phoneNumber;

    @FindBy(xpath = "//span[contains(text(), 'Save & Continue')]/..")
    WebElement saveContinueButton;

    @FindBy(xpath = "//div[@class=\"AddressBook__addressHolder\"]")
    List<WebElement> addressDetails;

    @FindBy(id = "wzrk-cancel")
    WebElement askLater;

    @FindBy(className = "DesktopHeader__iconPersonHolder")
    WebElement myProfile;

    @FindBy(className = "LogoutButton__menuIconLogOut")
    WebElement logoutBtn;

    @FindBy(xpath = "//div[text()='CLiQ Care']")
    WebElement cliqCareButton;


    public void userOpenApplication(String val) {
        driver.get(ConfigurationManager.getConfigValues("application.url"));
        askLater.click();
    }

    public boolean verifyUserOnHomePage(){
        return searchBar.isDisplayed();
    }

    public void clickOnLoginButton(){
        signUpBtn.click();
    }


    public void userEnterSearchProduct(String productName){
        pause(5);
        searchBar.click();
        searchBar.sendKeys(productName+Keys.ENTER);
    }

    public void userClickMyAccountIcon(){
        moveToElement(myProfile);
    }

    public void userClickLogoutButton(){
        logoutBtn.click();
    }


    public void navigateAddressInput(){
        driver.findElement(By.xpath("//div[text()='My account']")).click();
        addressButton.click();
    }

    public void userFillAddressDetails(String PIN,String firstname,String lastname,String address, String number){
        enterPIN.click();
        enterPIN.sendKeys(PIN);
        firstName.click();
        firstName.sendKeys(firstname);
        lastName.click();
        lastName.sendKeys(lastname);
        addressType.click();
        addressType.sendKeys(address);
        phoneNumber.click();
        phoneNumber.sendKeys(number);
    }

    @Override
    public void userClickAddressSubmit() {
        saveContinueButton.click();
    }

    public void displayAddressDetails(){
        for(WebElement data : addressDetails){
            System.out.println("--------------------Address--------------------------------");
            System.out.println(data.getText());
            System.out.println("-----------------------------------------------------------");
        }
        newAddressAdd.click();
    }


    public void clickOnCustomerCareBtn(){
        moveToElement(searchBar);
        click(cliqCareButton);
    }


}
