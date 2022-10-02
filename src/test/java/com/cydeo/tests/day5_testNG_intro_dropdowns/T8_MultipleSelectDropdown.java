package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8_MultipleSelectDropdown {

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
    public void multipleDropdown(){
        driver.navigate().to("https://practice.cydeo.com/dropdown");

        //3. Select all the options from multiple select dropdown.
        Select select = new Select(driver.findElement(By.xpath("//select[@name = 'Languages']")));
        List<WebElement> languages = driver.findElements(By.xpath("//select[@name = 'Languages']//option"));

        //4. Print out all selected values.
        for (WebElement eachLanguage : languages) {
            select.selectByVisibleText(eachLanguage.getText());
            HandleWait.wait(250);
            System.out.println(eachLanguage.getText());
            HandleWait.wait(1000);
        }
        //5. Deselect all values.
        select.deselectAll();





    }
}
/*
TC #8: Selecting value from multiple select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.
 */