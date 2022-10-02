package com.cydeo.practice.week05;

import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_SmartBear {

    @Test
    public void smartBearOrder() {

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");

        Driver.getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys("Tester");
        Driver.getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys("test");
        Driver.getDriver().findElement(By.xpath("//input[@class='button']")).click();

        Driver.getDriver().findElement(By.xpath("//a[.='Order']")).click();

        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select")));
        select.selectByVisibleText("FamilyAlbum");
        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();
        Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")).sendKeys("2");

        Faker faker = new Faker();
        Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']")).sendKeys(faker.name().fullName() + Keys.TAB +
                faker.address().streetName() + Keys.TAB + faker.address().cityName() + Keys.TAB + faker.address().state() + Keys.TAB + faker.address().zipCode().replace("-", ""));

        Driver.getDriver().findElement(By.xpath("//input[@value='Visa']")).click();
        Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']")).
                sendKeys(faker.numerify("################") + Keys.TAB + faker.number().numberBetween(10, 12) + "/" + faker.number().numberBetween(22, 29));


        Driver.getDriver().findElement(By.xpath("//a[@class='btn_light']")).click();

        String expectedResult = "New order has been successfully added.";
        String actualResult = Driver.getDriver().findElement(By.xpath("//strong")).getText();
        Assert.assertEquals(expectedResult,actualResult);
    }

}
/*
Smartbear software order placing
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click on Login button
6. Click on Order
7. Select familyAlbum from product, set quantity to 2
8. Click to “Calculate” button
9. Fill address Info with JavaFaker
• Generate: name, street, city, state, zip code
10. Click on “visa” radio button
11. Generate card number using JavaFaker
12. Click on “Process”
13. Verify success message “New order has been successfully added.”

    You have to implement the following Web automated checks over our DEMO ONLINE
    SHOP: https://www.demoblaze.com/index.html
    • Customer navigation through product categories: Phones, Laptops and Monitors
    • Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.  --- Create a custom method for adding products
    • Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
    • Click on "Place order".
    • Fill in all web form fields. ----USE JavaFaker---create a fillForm() custom method
    • Click on "Purchase"
    • Capture and log purchase Id and Amount.
    • Assert purchase amount equals expected.
    • Click on "Ok"
 */