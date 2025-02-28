package com.tatacliq.pages.web;

import com.tatacliq.pages.ui.CustomerPage;
import com.tatacliq.utils.ConfigurationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebCustomerPage extends WebBasePage implements CustomerPage {

    @FindBy(xpath = "//div[text()='Shopping']")
    WebElement allText;

    @FindBy(xpath = "//ul[@class='CustomerIssue__listGroup']/li")
    List<WebElement> issueList;

    @FindBy(xpath = "//div[@class='CustomerIssue__contactUsBtn']//span")
    WebElement contactUsBtn;

    @FindBy(xpath = "//div[@class='Button__base']")
    WebElement raiseCompliantButton;

    @FindBy(xpath = "//div[@class='CustomerIssue__header']")
    WebElement customerPageVerify;

    @FindBy(xpath = "//div[@class='Button__base']/span")
    WebElement nextBtn;

    @FindBy(xpath = "//input[@placeholder='Enter the name of the product']")
    WebElement nameInput;

    @FindBy(xpath = "//input[@placeholder='Copy paste the product page URL']")
    WebElement urlInput;

    @FindBy(xpath = "//textarea[@placeholder='Please describe your concern...']")
    WebElement commentInput;

    @FindBy(id = "fileinput")
    WebElement attachFile;

    @FindBy(xpath = "//span[text()='SUBMIT']")
    WebElement submitBtn;

    String Ticket_path = "//li[text()='%s']";

    String x_path_select = "//div[text()='%s']";

    @Override
    public boolean isCustomerPageDisplayed() {
        return allText.isDisplayed();
    }

    @Override
    public void userSelectIssueType(String value) {
        WebElement ele = driver.findElement(By.xpath(String.format(x_path_select, value)));
        click(ele);
    }

    @Override
    public void clickOnContactUsBtn() {
        contactUsBtn.click();
    }

    @Override
    public boolean isContactUsBtnDisplayed() {
        issueList.get(0).click();
        return contactUsBtn.isDisplayed();
    }

    @Override
    public void userSelectComplaintOption() {
        raiseCompliantButton.click();
    }

    @Override
    public boolean isFillingTabDisplayed() {
        return customerPageVerify.isDisplayed();
    }

    @Override
    public void userFillProblemDetails() {
        if (isDisplayedCheck(nameInput) && isDisplayedCheck(urlInput)) {
            nameInput.click();
            nameInput.sendKeys(ConfigurationManager.getConfigValues("name.input"));
            urlInput.click();
            urlInput.sendKeys(ConfigurationManager.getConfigValues("url.input"));
            commentInput.click();
            commentInput.sendKeys(ConfigurationManager.getConfigValues("comment.input"));
        } else {
            commentInput.click();
            commentInput.sendKeys(ConfigurationManager.getConfigValues("comment.input"));
        }
        nextBtn.click();

    }

    @Override
    public void uploadAttachment() {
        attachFile.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\file\\Screen.jpeg");
        click(nextBtn);
    }

    @Override
    public boolean verifyUserCanSubmitComplaint() {
        return submitBtn.isDisplayed();
    }

    @Override
    public void userSelectVariousTicketOptions(String value) {
        WebElement ele = driver.findElement(By.xpath(String.format(Ticket_path, value)));
        click(ele);
    }
}
