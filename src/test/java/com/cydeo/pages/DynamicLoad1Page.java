package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoad1Page {

    public DynamicLoad1Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Start']")
    public WebElement startButton;

    @FindBy(xpath = "//div[@id='loading']")
    public WebElement loadingBar;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@id='flash-messages']")
    public WebElement errorMessage;


}
//2. Click to start
//3. Wait until loading bar disappears
//4. Assert username inputbox is displayed
//5. Enter username: tomsmith
//6. Enter password: incorrectpassword
//7. Click to Submit button