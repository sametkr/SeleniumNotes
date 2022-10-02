package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.navigate().to("https://login1.nextbasecrm.com/");

        WebElement rememberMe = driver.findElement(By.className("login-item-checkbox-label"));
        String exceptedRememberMeLabel = "Remember me on this computer";
        String actualRememberMeLabel = rememberMe.getText();
        if (actualRememberMeLabel.equals(exceptedRememberMeLabel)){
            System.out.println("Label validation PASSED!");
        }else {
            System.out.println("Label validation PASSED!");
        }


        WebElement forgotPassword = driver.findElement(By.className("login-link-forgot-pass"));
        String expectedForgotPassword = "FORGOT YOUR PASSWORD?";
        String actualForgotPassword = forgotPassword.getText();
        if (actualForgotPassword.equals(expectedForgotPassword)){
            System.out.println("Forgot Password link validation PASSED!");
        }else {
            System.out.println("Forgot Password link validation FAILED!");
        }


        String expectedForgotPasswordHrefValue = "forgot_password=yes";
        String actualForgotPasswordHrefValue = forgotPassword.getAttribute("href");
        if (actualForgotPasswordHrefValue.contains(expectedForgotPasswordHrefValue)){
            System.out.println("Forgot Password Href validation PASSED!");
        }else {
            System.out.println("Forgot Password Href validation FAILED!");
        }

        driver.close();




    }
}
/*
TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes
PS: Inspect and decide which locator you should be using to locate web
elements.
 */