package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase_6 {

    public static void main(String[] args) {

        // Step 1. Go to https://practice-cybertekschool.herokuapp.com
        // Step 2. Click on “Registration Form”
        // Step 3. Enter “user” into username input box.
        // Step 4. Verify that warning message is displayed: “The username must be more than 6 and less than 30 characters long”

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Registration Form")).click();

        driver.findElement(By.name("username")).sendKeys("user");

        String expected = "The username must be more than 6 and less than 30 characters long";
        String actual = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[3]/div/small[2]")).getText();

        StringUtility.verifyEquals(expected, actual);

        driver.close();
    }

}
