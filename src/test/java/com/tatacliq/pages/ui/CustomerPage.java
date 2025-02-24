package com.tatacliq.pages.ui;

public interface CustomerPage {
    boolean isCustomerPageDisplayed();

    void userSelectIssueType(String value);

    void clickOnContactUsBtn();

    boolean isContactUsBtnDisplayed();

    void userSelectComplaintOption();

    boolean isFillingTabDisplayed();

    void userFillProblemDetails();

    void uploadAttachment();

    boolean verifyUserCanSubmitComplaint();

    void userSelectVariousTicketOptions(String value);
}
