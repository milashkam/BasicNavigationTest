package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase_1 {

    public static void main(String[] args) {

       // Step 1. Go to https://practice-cybertekschool.herokuapp.com
        // 2. Click on “Sign Up For Mailing List”
        // 3. Enter any valid name
        // 4. Enter any valid email
        // 5. Click on “Sign Up” button
        // Expected result: Following message should be displayed:
        // “Thank you for signing up. Click the button below to return to the home page.” Home button should be displayed.

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Sign Up For Mailing List")).click();

        driver.findElement(By.name("full_name")).sendKeys("Mahriban Gurbanova");

        driver.findElement(By.name("email")).sendKeys("gmahriban89@gmail.com");

        driver.findElement(By.name("wooden_spoon")).click();

        String buttonactual = driver.findElement(By.tagName("h3")).getText();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";

        StringUtility.verifyEquals(expected, buttonactual);

        WebElement actualhome = driver.findElement(By.className("nav-link"));
        actualhome.click();

        driver.close();
    }
}
