package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase_5 {

    public static void main(String[] args) {

        // Step 1. Go to https://practice-cybertekschool.herokuapp.com
        // Step 2. Click on “Registration Form”
        // Step 3. Enter “123” into last name input box.
        // Step 4. Verify that warning message is displayed: “The last name can only consist of alphabetical letters and dash”

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Registration Form")).click();

        driver.findElement(By.name("lastname")).sendKeys("1234");

        String expected = "The last name can only consist of alphabetical letters and dash";
        String actual = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[3]")).getText();

        StringUtility.verifyEquals(expected, actual);

        driver.close();
    }
}
