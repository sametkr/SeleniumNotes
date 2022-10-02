package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_Scroll_With_JS_Executor {

    @Test
    public void scroll_with_JS(){

        Driver.getDriver().get("https://practice.cydeo.com/large");
        WebElement poweredByCydeo = Driver.getDriver().findElement(By.xpath("//div[@style='text-align: center;']"));
        WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[.='Home']"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        HandleWait.wait(1500);
        js.executeScript("arguments[0].scrollIntoView(true)", poweredByCydeo);
        HandleWait.wait(1500);
        js.executeScript("arguments[0].scrollIntoView(true)", homeLink);

    }
}
/*
TC #7: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/large
3- Scroll down to “Cydeo” link
4- Scroll up to “Home” link
5- Use below provided JS method only
JavaScript method to use : arguments[0].scrollIntoView(true)
Note: You need to locate the links as web elements and pass them as
arguments into executeScript() method
 */