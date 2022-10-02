package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WebTableUtils {

    public static String returnOrderDate(WebDriver driver, String customerName) {

        return driver.findElement(By.xpath("//td[.='" + customerName + "']/following-sibling::td[3]")).getText();
    }

    public static void orderVerify(WebDriver driver, String customerName, String expectedOrderDate) {

        String actualOrderDate = driver.findElement(By.xpath("//td[.='" + customerName + "']/following-sibling::td[3]")).getText();
        Assert.assertEquals(actualOrderDate, expectedOrderDate);

    }
}

/*
Method #1 info:
• Name: returnOrderDate ()
• Return type: String
• Arg1: WebDriver driver
• Arg2: String customerName
This method should accept a customerName and return the customer order date
as a String

Method #2 info:
• Name: orderVerify ()
• Return type: void
• Arg1: WebDriver driver
• Arg2: String customerName
• Arg3: String expectedOrderDate
This method should accept above mentioned arguments and internally assert
expectedOrderDate matching actualOrderDate
 */