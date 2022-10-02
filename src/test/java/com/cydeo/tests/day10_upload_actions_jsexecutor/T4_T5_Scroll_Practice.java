package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_T5_Scroll_Practice {

    @Test
    public void scroll_practice(){

        Driver.getDriver().get("https://practice.cydeo.com/");

        Actions actions = new Actions(Driver.getDriver());

        WebElement poweredByCydeo = Driver.getDriver().findElement(By.xpath("//div[@style='text-align: center;']"));
        actions.moveToElement(poweredByCydeo).perform();

        HandleWait.wait(2000);

        WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[.='Home']"));
        actions.moveToElement(homeLink).perform();
        //actions.sendKeys(Keys.HOME).perform();

        Driver.closeDriver();

    }
    @Test
    public void scroll_practice2(){

        Driver.getDriver().get("https://practice.cydeo.com/");
        Driver.closeDriver();
    }


}
/*
TC #4: Scroll practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/
3- Scroll down to “Powered by CYDEO”
4- Scroll using Actions class “moveTo(element)” method
TC #5: Scroll practice 2
1- Continue from where the Task 4 is left in the same test.
2- Scroll back up to “Home” link using PageUP button
 */