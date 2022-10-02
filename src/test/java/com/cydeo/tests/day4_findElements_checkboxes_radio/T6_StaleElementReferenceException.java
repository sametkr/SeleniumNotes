package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T6_StaleElementReferenceException {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://practice.cydeo.com/abtest");

        WebElement cydeoLink = driver.findElement(By.xpath("//a[@target='_blank']")); // ( //a[.='CYDEO'] )
        System.out.println("Verifying Cydeo Link is displayed: "+cydeoLink.isDisplayed());

        HandleWait.wait(2000);
        driver.navigate().refresh();

        //StaleElementReferenceException.main(T6_StaleElementReferenceException.java:30)
        //we need to re-assign navigation or use try catch but best way is re-assigning (re-locating)
        cydeoLink = driver.findElement(By.xpath("//a[@target='_blank']")); // re-assign same navigator
        System.out.println("Verifying Cydeo Link is displayed: "+cydeoLink.isDisplayed());

        driver.close();

    }
}
/*
TC #6: StaleElementReferenceException Task
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/abtest
3- Locate “CYDEO” link, verify it is displayed.
4- Refresh the page.
5- Verify it is displayed, again.
This is a simple StaleElementReferenceException to understand what is
this exception and how to handle it.

 */