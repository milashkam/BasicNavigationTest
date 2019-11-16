package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase_7 {

    public static void main(String[] args) {
            // Step 1. Go to https://practice-cybertekschool.herokuapp.com
        // Step 2. Click on “Registration Form”
        // Step 3. Enter “testers@email” into email input box.
        // Step 4. Verify that warning message is displayed: “email address is not a validEmail format is not correct”

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Registration Form")).click();

        driver.findElement(By.name("email")).sendKeys("testers@email");

        String expected1 = "email address is not a valid";

        String actual1 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[2]")).getText();

        String expected2 = "Email format is not correct";
        String actual2 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[3]")).getText();

        StringUtility.verifyEquals(expected1, actual1);
        StringUtility.verifyEquals(expected2, actual2);

        driver.close();
    }
}
