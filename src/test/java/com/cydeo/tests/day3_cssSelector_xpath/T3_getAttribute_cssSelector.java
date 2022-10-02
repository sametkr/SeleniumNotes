package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_cssSelector {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://login1.nextbasecrm.com/");

        WebElement signInButton = driver.findElement(By.cssSelector("input[class='login-btn']"));  // or type='submit' or any attribute name and attribute value
        String actualSignInButtonText = signInButton.getAttribute("value");
        String expectedSignInButtonText = "Log In";

        if (actualSignInButtonText.equals(expectedSignInButtonText)){
            System.out.println("Sign In Button Text verification PASSED!");
        }else {
            System.out.println("Sign In Button Text verification FAILED!");
        }

        driver.close();

    }
}
/*
TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “Log in” button text is as expected:
Expected: Log In
PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
 */