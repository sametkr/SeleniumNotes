package com.cydeo.practice.week06.pomForReview;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WaitTasksPage {

    public WaitTasksPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//button[@class='btn btn-success']")
    public WebElement clickMeToOpenButton;

    @FindBy (xpath = "//button[@id='enable-button']")
    public WebElement enableButton;

    @FindBy (xpath = "//button[@id='disable']")
    public WebElement disableButton;
}
