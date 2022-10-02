package com.cydeo.practice.week06.pomForReview;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.=' Home']")
    public WebElement homeButton;

    @FindBy(xpath = "//i[@class='material-icons card_travel']")
    public WebElement productsButton;

    @FindBy(xpath = "//a[.=' Cart']")
    public WebElement cartButton;

    @FindBy(xpath = "//a[.=' Contact us']")
    public WebElement contactUsButton;

    @FindBy(tagName = "a")
    public List<WebElement> lists;
}
