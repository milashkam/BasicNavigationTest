package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestCase_2 {

    public static void main(String[] args) {

        // Step 1. Go to https://practice-cybertekschool.herokuapp.com
        // Step 2. Verify that number of listed examples is equals to 48.
        // Hint: use findElemnts() and size() methods.

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        List<WebElement> list=  driver.findElements(By.className("list-group-item"));
        // int Count = list.size();

        int actual = list.size();
        StringUtility.verifyEqualsInt(actual, 48);

       // System.out.println(list.size());
        driver.quit();



    }
}
