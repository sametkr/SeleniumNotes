package com.cydeo.practice.week06;

import com.cydeo.practice.week06.pomForReview.ContactUsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC6_ContactUsForm {

    @Test
    public void contact_us_form(){
        Driver.getDriver().get("http://automationexercise.com");
        ContactUsPage page = new ContactUsPage();
        // 3. Verify that home page is visible successfully
        Assert.assertTrue(page.homeButton.isDisplayed());
        // 4. Click on 'Contact Us' button
        page.contactUsButton.click();
        // 5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(page.getInTouchText.isDisplayed());
        // 6. Enter name, email, subject and message
        Faker faker = new Faker();
        page.nameInputBox.sendKeys(faker.name().fullName());
        page.emailInputBox.sendKeys(faker.internet().emailAddress());
        page.subjectInputBox.sendKeys(faker.chuckNorris().fact());
        page.messageInputBox.sendKeys(faker.yoda().quote());
        // 7. Upload file
        page.uploadFileButton.sendKeys("C:\\Users\\sam\\Desktop\\dur.jpeg");
        // 8. Click 'Submit' button
        page.submitButton.click();
        // 9. Click OK button
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(page.successMessage.isDisplayed());
        // 11. Click 'Home' button and verify that landed to home page successfully
        page.homeButton.click();
        BrowserUtils.verifyTitle(Driver.getDriver(), "Automation Exercise");



    }
}

// 1. Launch browser
// 2. Navigate to url 'http://automationexercise.com'
// 3. Verify that home page is visible successfully
// 4. Click on 'Contact Us' button
// 5. Verify 'GET IN TOUCH' is visible
// 6. Enter name, email, subject and message
// 7. Upload file
// 8. Click 'Submit' button
// 9. Click OK button
// 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
// 11. Click 'Home' button and verify that landed to home page successfully