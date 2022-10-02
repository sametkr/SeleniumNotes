package com.cydeo.practice.week06.webstaurantTask;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest {

    @Test
    public void test(){
        Driver.getDriver().get("https://www.webstaurantstore.com/");

        SearchResultPage page = new SearchResultPage();
        page.searchBox.sendKeys("stainless work table");
        page.searchSubmitButton.click();

        List<WebElement> resultList = page.resultList;

        for (WebElement eachElement : resultList) {
            Assert.assertTrue(eachElement.getText().toLowerCase().contains("table"));
        }

    }
}
/*
Go to https://www.webstaurantstore.com/
Search for 'stainless work table'
Check the search result ensuring every product has the word 'Table' in its title
Add the last of found items to Cart.
Empty Cart.
 */