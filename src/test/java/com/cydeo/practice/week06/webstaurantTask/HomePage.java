package com.cydeo.practice.week06.webstaurantTask;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@id='searchval']")
    public WebElement searchBox;

    @FindBy (xpath = "//div[@id='global-search']//button[@type='submit']")
    public WebElement searchSubmitButton;




}
