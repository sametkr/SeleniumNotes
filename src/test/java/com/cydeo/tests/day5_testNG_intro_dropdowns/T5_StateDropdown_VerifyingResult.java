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

public class T5_StateDropdown_VerifyingResult {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void stateDropdown(){
        driver.navigate().to("http://practice.cybertekschool.com/dropdown");
        Select selectedState = new Select(driver.findElement(By.xpath("//select[@id = 'state']")));

        //3. Select Illinois
        selectedState.selectByVisibleText("Illinois");

        //4. Select Virginia
        selectedState.selectByValue("VA");

        //5. Select California
        selectedState.selectByIndex(5);

        //6. Verify final selected option is California.
        String expectedSelectedStateText = "California";
        String actualSelectedStateText = selectedState.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedSelectedStateText, actualSelectedStateText);
    }
}
/*
TC #5: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
 */