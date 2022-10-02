package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T5_checkboxes {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://practice.cydeo.com/checkboxes");

        //2. Confirm checkbox #1 is NOT selected by default
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@name='checkbox1']"));
        System.out.println("Checkbox 1 is selected (expecting false): "+checkbox1.isSelected());

        //3. Confirm checkbox #2 is SELECTED by default.
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='checkbox2']"));
        System.out.println("Checkbox 2 is selected (excepting true): "+checkbox2.isSelected());

        HandleWait.wait(2000);
        //4. Click checkbox #1 to select it.
        checkbox1.click();

        HandleWait.wait(2000);
        //5. Click checkbox #2 to deselect it.
        checkbox2.click();

        //6. Confirm checkbox #1 is SELECTED.
        System.out.println("Checkbox 1 is selected (excepting true): "+checkbox1.isSelected());

        //7. Confirm checkbox #2 is NOT selected.
        System.out.println("Checkbox 2 is selected (excepting false): "+checkbox2.isSelected());

        driver.close();
    }
}
/*
Practice: Checkboxes
1. Go to http://practice.cydeo.com/checkboxes
2. Confirm checkbox #1 is NOT selected by default
3. Confirm checkbox #2 is SELECTED by default.
4. Click checkbox #1 to select it.
5. Click checkbox #2 to deselect it.
6. Confirm checkbox #1 is SELECTED.
7. Confirm checkbox #2 is NOT selected.
 */