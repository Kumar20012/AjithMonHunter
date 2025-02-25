package com.tatacliq.pages.android;

import com.tatacliq.pages.ui.CustomerPage;
import com.tatacliq.utils.ConfigurationManager;
import org.hamcrest.Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class AndroidCustomerPage extends AndroidBasePage implements CustomerPage {
    @FindBy(id = "com.tul.tatacliq:id/tv_other_issues")
    WebElement helpBtn;

    String ISSUE_XPATH="//android.widget.TextView[@resource-id='com.tul.tatacliq:id/tv_issues_type_title' and @text='%s']";

    @FindBy(id="com.tul.tatacliq:id/tv_issues_title")
    List<WebElement> queryList;

    @FindBy(id="com.tul.tatacliq:id/txtContactUs")
    WebElement contactUsBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Write to us / Raise a complaint\"]")
    WebElement raiseComplaintOption;

    @FindBy(xpath = "//android.widget.EditText[@text='Enter the name of the product']")
    WebElement nameInput;
    @FindBy(xpath = "//android.widget.EditText[@text='Copy paste the product page URL']")
    WebElement urlInput;
    @FindBy(xpath = "//android.widget.EditText[@text='Please describe your concern...']")
    WebElement commentInput;
    @FindBy(id = "com.tul.tatacliq:id/btnNext")
    WebElement nextBtn;
    @FindBy(id="com.tul.tatacliq:id/tv_attach_file")
    WebElement attachFile;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Attach\"]")
    WebElement attachBtn;
    @FindBy(xpath = "//android.widget.Button[@text='SUBMIT']")
    WebElement submitBtn;

    String TICKET_XPATH="//android.widget.TextView[@resource-id='com.tul.tatacliq:id/tv_issues_title' and @text='%s']";

    public boolean isCustomerPageDisplayed(){
       return helpBtn.isDisplayed();
    }
    public void userSelectIssueType(String value){
        helpBtn.click();
        WebElement issue= driver.findElement(By.xpath(String.format(ISSUE_XPATH,value)));
        issue.click();
        queryList.getFirst().click();
    }
    public void clickOnContactUsBtn(){
        contactUsBtn.click();
    }
    public boolean isContactUsBtnDisplayed(){
        return contactUsBtn.isDisplayed();
    }
    public void userSelectComplaintOption(){
        raiseComplaintOption.click();
    }
    public boolean isFillingTabDisplayed(){
        return  nextBtn.isDisplayed();
    }
    public void userFillProblemDetails(){
        if(isDisplayedCheck(nameInput) && isDisplayedCheck(urlInput)){
           nameInput.sendKeys(ConfigurationManager.getConfigValues("name.input"));
           urlInput.sendKeys(ConfigurationManager.getConfigValues("url.input"));
           commentInput.sendKeys(ConfigurationManager.getConfigValues("comment.input"));
        }else{
            commentInput.sendKeys(ConfigurationManager.getConfigValues("comment.input"));
        }
        nextBtn.click();
    }
    public void uploadAttachment(){
        attachFile.click();
        attachBtn.click();
        driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.google.android.documentsui:id/icon_thumb'])[1]")).click();
        if(nextBtn.isEnabled()){
            nextBtn.click();
        }
    }
    public boolean verifyUserCanSubmitComplaint(){
        return submitBtn.isDisplayed();
    }
    public void userSelectVariousTicketOptions(String value){
        WebElement ticket= driver.findElement(By.xpath(String.format(TICKET_XPATH,value)));
        ticket.click();
    }


}
