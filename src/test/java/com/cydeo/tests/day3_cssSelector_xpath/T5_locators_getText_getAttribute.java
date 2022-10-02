package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class T5_locators_getText_getAttribute {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");

        driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[2]/div[1]/input")).sendKeys("incorrect");
        driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[4]/button")).click();

        String expectedErrorLabelText = "Login or E-mail not found";
        String actualErrorLabelText = driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[2]")).getText();

        if (actualErrorLabelText.equals(expectedErrorLabelText)){
            System.out.println("Error label verification PASSED!");
        }else {
            System.out.println("Error label verification FAILED!");
        }

        driver.close();

    }
}
/*
TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Enter incorrect username into login box:
4- Click to `Reset password` button
5- Verify “error” label is as expected
Expected: Login or E-mail not found
PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
 */