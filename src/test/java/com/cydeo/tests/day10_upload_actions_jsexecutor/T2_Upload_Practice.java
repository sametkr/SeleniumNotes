package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    @Test
    public void upload_test(){
        Driver.getDriver().get("https://practice.cydeo.com/upload");
        //we uploaded file to directly webElement with sendKeys method
        Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\sam\\Desktop\\dur.jpeg");
        Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']")).click();

        WebElement fileUploadedHeader = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedHeader.isDisplayed());

    }
}
/*
TC #2 Upload Test
1. Go to https://practice.cydeo.com/upload
2. Find some small file from your computer, and get the path of it.
3. Upload the file.
4. Assert:
-File uploaded text is displayed on the page
 */

//C:\Users\sam\Desktop\dur.jpeg