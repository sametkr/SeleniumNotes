package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T5_Windows_Practice {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://practice.cydeo.com/windows");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

    @Test
    public void multipleWindowTask(){
        //Storing the main page's window handle as string is good practice for future re-usable purposes
        String mainHandle = driver.getWindowHandle();
        //System.out.println(mainHandle);

        //4. Assert: Title is “Windows”
        Assert.assertEquals(driver.getTitle(), "Windows");
        System.out.println("Title before click: "+driver.getTitle());

        //5. Click to: “Click Here” link
        driver.findElement(By.xpath("//a[@target='_blank']")).click();
        //System.out.println("Title after click: "+driver.getTitle());

        //6. Switch to new Window.
        Set<String> allWindowHandles = driver.getWindowHandles();
        //   window handle 1 - main window
        //   window handle 2 - 2nd window

        for (String each: allWindowHandles){
            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: "+driver.getTitle());
        }

        //7. Assert: Title is “New Window”
        Assert.assertEquals(driver.getTitle(), "New Window");
        System.out.println("Title after click: "+driver.getTitle());

        //If we want to go back to main page, we can use already stored main handle
        //driver.switchTo().window(mainHandle);
    }


}
/*
TC #5: Window Handle practice
1. Create a new class called: T5_WindowsPractice
2. Create new test and make set ups
3. Go to : https://practice.cydeo.com/windows
4. Assert: Title is “Windows”
5. Click to: “Click Here” link
6. Switch to new Window.
7. Assert: Title is “New Window”
 */