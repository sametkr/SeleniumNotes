package com.cydeo.practice.week06.pomForReview;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage{

    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameInputBox;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@name='subject']")
    public WebElement subjectInputBox;

    @FindBy(xpath = "//textarea[@name='message']")
    public WebElement messageInputBox;

    @FindBy(xpath = "//input[@name='upload_file']")
    public WebElement uploadFileButton;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//h2[.='Get In Touch']")
    public WebElement getInTouchText;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    public WebElement successMessage;


}
