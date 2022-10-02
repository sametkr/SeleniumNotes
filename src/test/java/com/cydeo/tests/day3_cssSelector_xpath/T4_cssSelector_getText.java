package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class T4_cssSelector_getText {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");

        String expectedResetPasswordButtonText = "Reset password";
        String actualResetPasswordButtonText = driver.findElement(By.cssSelector("button[value='Reset password']")).getText();

        if (actualResetPasswordButtonText.equals(expectedResetPasswordButtonText)) {
            System.out.println("Button text verification PASSED!");
        } else {
            System.out.println("Button text verification FAILED!");
        }
        driver.close();

    }
}
/*
TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Verify “Reset password” button text is as expected:
Expected: Reset password
PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
 */