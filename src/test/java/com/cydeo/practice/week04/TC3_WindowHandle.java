package com.cydeo.practice.week04;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class TC3_WindowHandle {

    public WebDriver driver;

    //Local date
    String date = LocalDate.now().toString();
    String year = date.substring(0,4);
    String month = date.substring(5,7);
    String day = date.substring(8);
    int tomorrow = Integer.parseInt(day)+1;

    //Local Time
    String time = LocalTime.now().toString();
    String hour = time.substring(0,2);
    String minute = time.substring(3,5);
    String localtime = hour+":"+minute;


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
    public void windowHande(){
        driver.navigate().to("https://shino.de/parkcalc/");
        String mainPage = driver.getWindowHandle();

        if (Integer.parseInt(hour) >= 12){
            driver.findElement(By.xpath("(//input[@value='PM'])[1]")).click();
            driver.findElement(By.xpath("(//input[@value='PM'])[2]")).click();

        }

        WebElement setToday = driver.findElement(By.xpath("(//td/a/img[@src='cal.gif'])[1]"));
        setToday.click();

        for (String each : driver.getWindowHandles()){
            driver.switchTo().window(each);
        }

        driver.findElement(By.xpath("//a[.= '"+day+"']")).click();

        driver.switchTo().window(mainPage);

        WebElement setTime = driver.findElement(By.xpath("//input[@name='StartingTime']"));
        setTime.clear();
        setTime.sendKeys(localtime);

        WebElement setLeavingDate = driver.findElement(By.xpath("(//td/a/img[@src='cal.gif'])[2]"));
        setLeavingDate.click();

        for (String each : driver.getWindowHandles()){
            driver.switchTo().window(each);
        }
        driver.findElement(By.xpath("//a[.='"+tomorrow+"']")).click();

        driver.switchTo().window(mainPage);

        setTime = driver.findElement(By.xpath("//input[@name='LeavingTime']"));
        setTime.clear();
        setTime.sendKeys(localtime);

    }

}

/*
    automate the following scenarios for this website https://shino.de/parkcalc/
Scenario 1)
-  Using the Valet parking lot, set today as the entry date & time and tomorrow as the exit giving a full 24 hour window (you can attempt to use the DatePicker).
*/
