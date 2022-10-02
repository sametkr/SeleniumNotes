package com.cydeo.practice.week04;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC2_Iframe {
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
    public void iFrame(){
        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));
        WebElement element = driver.findElement(By.xpath("//p"));

        String expectedResult = "Double-click me to change my text color.";
        String actualResult = element.getText();

        Assert.assertEquals(expectedResult,actualResult, "Text verification not PASSED!");




    }
}
/*
//1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
//2. Switch to iframe.
//3. Get the text “Double-click me to change my text color.” and verify the text
}
 */