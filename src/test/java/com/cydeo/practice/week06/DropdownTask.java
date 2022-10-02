package com.cydeo.practice.week06;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTask {

    @Test
    public void smartBearSoftware(){
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester");
        Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys("test");
        Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();

        //3. Click  Order button
        Driver.getDriver().findElement(By.xpath("//a[.='Order']")).click();
        //4. Verify under Product Information, selected option is “MyMoney”
        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "MyMoney");

        //5. Then select FamilyAlbum, make quantity 2, and click Calculate,
        select.selectByVisibleText("FamilyAlbum");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "FamilyAlbum");
        Driver.getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys("2");
        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();

        //6. Then verify Total is equal to Quantity*PricePerUnit


    }
}
/*
Task3:
    1. Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    2. Login with username: Tester, password: test
    3. Click  Order button
    4. Verify under Product Information, selected option is “MyMoney”
    5. Then select FamilyAlbum, make quantity 2, and click Calculate,
    6. Then verify Total is equal to Quantity*PricePerUnit
 */