package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://practice.cydeo.com/javascript_alerts");
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test (priority = 1)
    public void jsAlert(){
        //3. Click to “Click for JS Alert” button
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement alertText = driver.findElement(By.xpath("//p[@id='result']"));
        String actualAlertText = alertText.getText();
        String expectedAlertText = "You successfully clicked an alert";
        Assert.assertEquals(expectedAlertText,actualAlertText, "Alert Text not matching");
        Assert.assertTrue(alertText.isDisplayed(), "Alert Text message is NOT displayed.");
    }

    @Test (priority = 2)
    public void jsConfirm(){
        //3. Click to “Click for JS Confirm” button
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        String expectedAlertText = "You clicked: Ok";
        String actualAlertText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(expectedAlertText, actualAlertText, "Alert Text not matching");
    }

    @Test (priority = 3)
    public void jsPrompt(){
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");

        //5. Click to OK button from the alert
        alert.accept();

        //6. Verify “You entered: hello” text is displayed.
        String expectedResult = "You entered: hello";
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(expectedResult, actualResult, "Alert text not matching ");
    }
}

/*
TC #1: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Verify “You successfully clicked an alert” text is displayed.

TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.

TC #3: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Prompt” button
4. Send “hello” text to alert
5. Click to OK button from the alert
6. Verify “You entered: hello” text is displayed.
 */