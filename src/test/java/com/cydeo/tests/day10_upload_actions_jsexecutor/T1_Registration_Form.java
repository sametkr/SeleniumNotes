package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T1_Registration_Form {

    @AfterMethod
    public void tearDownMethod(){
        Driver.getDriver().close();
    }

    @Test
    public void registration_form_test() {

        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        Faker faker = new Faker();

        //3. Enter first name
        WebElement inputFirstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        inputFirstName.sendKeys(faker.name().firstName());
        //4. Enter last name
        WebElement inputLastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys(faker.name().lastName());
        //5. Enter username
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        inputUsername.sendKeys(faker.name().username().replace(".",""));
        //6. Enter email address
        WebElement inputEmail = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys(faker.internet().emailAddress());
        //7. Enter password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys(faker.internet().password());
        //8. Enter phone number
        WebElement inputPhoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        inputPhoneNumber.sendKeys(faker.numerify("###-###-####"));
        //9. Select a gender from radio buttons
        Driver.getDriver().findElement(By.xpath("//input[@value='male']")).click();
        //10.Enter date of birth
        WebElement inputDateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        inputDateOfBirth.sendKeys("11/11/1990");
        //11. Select Department/Office
        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        select.selectByVisibleText("Department of Engineering");
        //12.Select Job Title
        Select select2 = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        select2.selectByVisibleText("SDET");
        //13.Select programming language from checkboxes
        Driver.getDriver().findElement(By.xpath("//input[@value='java']")).click();
        //14.Click to sign up button
        Driver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        //15.Verify success message “You’ve successfully completed registration.” is displayed.
        String expectedSuccessMessage = "You've successfully completed registration!";
        String actualSuccessMessage = Driver.getDriver().findElement(By.xpath("//div[@role='alert']//p")).getText();

        Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage);




    }
}


/*
TC#1: Registration form confirmation
Note: Use JavaFaker OR read from configuration.properties file when possible.
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10.Enter date of birth
11.Select Department/Office
12.Select Job Title
13.Select programming language from checkboxes
14.Click to sign up button
15.Verify success message “You’ve successfully completed registration.” is
displayed.
Note:
1. Use new Driver utility class and method
2. User JavaFaker when possible
3. User ConfigurationReader when it makes sense
 */