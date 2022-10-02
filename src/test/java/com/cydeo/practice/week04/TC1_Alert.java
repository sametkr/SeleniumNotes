package com.cydeo.practice.week04;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1_Alert {

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
    public void demoBlaze(){
        driver.navigate().to("https://www.demoblaze.com/index.html");
        WebElement laptopCategories = driver.findElement(By.xpath("//a[.='Laptops']"));
        laptopCategories.click();
        WebElement sonyVaioI5 = driver.findElement(By.xpath("//a[.='Sony vaio i5']"));
        sonyVaioI5.click();
        WebElement addCart = driver.findElement(By.xpath("//a[@onclick='addToCart(8)']"));
        addCart.click();

        HandleWait.wait(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();





    }
}


/*
    You have to implement the following Web automated checks over our DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
• Customer navigation through product categories: Phones, Laptops and Monitors
• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
*/