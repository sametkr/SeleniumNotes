package com.cydeo.practice.week06;

import com.cydeo.practice.week06.pomForReview.WaitTasksPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WaitExamples {

    WaitTasksPage waitTasksPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        waitTasksPage = new WaitTasksPage();
        wait = new WebDriverWait(Driver.getDriver(),10);
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
    @Test
    public void tc1_explicitWait(){
        // 2. Click on "Click me, to Open an alert after 5 seconds"
        waitTasksPage.clickMeToOpenButton.click();
        // 3. Explicitly wait until alert is present
        wait.until(ExpectedConditions.alertIsPresent());
        // 4. Then handle the Javascript alert
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }
    @Test
    public void tc2_enable_button(){
        //2. Click on "Enable button after 10 seconds"
        waitTasksPage.enableButton.click();
        //3. Explicitly wait until the button is enabled
        wait.until(ExpectedConditions.elementToBeClickable(waitTasksPage.disableButton));
        //4. Then verify the button is enabled
        Assert.assertTrue(waitTasksPage.disableButton.isEnabled());
    }
}
/*
Task1:
    1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
    2. Click on "Click me, to Open an alert after 5 seconds"
    3. Explicitly wait until alert is present
    4. Then handle the Javascript alert
 */
/*
Task2:
    1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
    2. Click on "Enable button after 10 seconds"
    3. Explicitly wait until the button is enabled
    4. Then verify the button is enabled
 */