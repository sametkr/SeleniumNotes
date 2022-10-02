package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        // 1- Setup browser driver
        WebDriverManager.chromedriver().setup();

        // 2- Create instance of the Selenium WebDriver (driver object)
        // This line opening an empty browser
        WebDriver driver = new ChromeDriver();

        // 3- Go to "https://www.tesla.com" URL MUST CORRECT!
        driver.get("https://www.tesla.com");

        //get the title of the page
        System.out.println("driver.getTitle() = " + driver.getTitle());

        // Get the current URL using selenium
        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        Thread.sleep(3000);

        // 4- Use Selenium to navigate back
        driver.navigate().back();

        Thread.sleep(3000);

        // 5- Use Selenium to navigate back
        driver.navigate().forward();

        Thread.sleep(3000);

        // 6- Use Selenium to navigate refresh
        driver.navigate().refresh();

        Thread.sleep(3000);

        // 7- use navigate().to(); google
        driver.navigate().to("https://www.google.com");

        // get the title of the page
        System.out.println("driver.getTitle() = " + driver.getTitle());

        // Get the current URL using selenium
        currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        driver.manage().window().maximize();

        Thread.sleep(3000);

        // this will close the currently opened window
        driver.close();

        // this will close all of opened windows
        driver.quit();



    }
}
