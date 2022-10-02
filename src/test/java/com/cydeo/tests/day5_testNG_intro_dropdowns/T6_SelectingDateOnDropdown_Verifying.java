package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T6_SelectingDateOnDropdown_Verifying {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void selectData(){
        driver.navigate().to("https://practice.cydeo.com/dropdown");

        //Select year using : visible text
        Select year = new Select(driver.findElement(By.xpath("//select[@id = 'year']")));
        year.selectByVisibleText("1923");

        //Select month using : value attribute
        Select month = new Select(driver.findElement(By.xpath("//select[@id = 'month']")));
        month.selectByValue("11");

        //Select day using : index number
        Select day = new Select(driver.findElement(By.xpath("//select[@id = 'day']")));
        day.selectByIndex(0);

        //3. Select “December 1st, 1923” and verify it is selected.
        Assert.assertEquals(year.getFirstSelectedOption().getText(), "1923", "Selected year is wrong!");
        Assert.assertEquals(month.getFirstSelectedOption().getText(), "December", "Selected month is wrong!");
        Assert.assertEquals(day.getFirstSelectedOption().getText(), "1", "Selected day is wrong!");




    }
}
/*
TC #6: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
Select year using : visible text
Select month using : value attribute
Select day using : index number
 */