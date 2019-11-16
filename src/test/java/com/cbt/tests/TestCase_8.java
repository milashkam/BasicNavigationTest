package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase_8 {

    public static void main(String[] args) {

        //  Step 1. Go to https://practice-cybertekschool.herokuapp.com
        //  Step 2. Click on “Registration Form”
        //  Step 3. Enter “5711234354” into phone number input box.
        //  Step 4. Verify that warning message is displayed: “Phone format is not correct”

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Registration Form")).click();

        driver.findElement(By.name("phone")).sendKeys("5711234354");

        String expected = "Phone format is not correct";
        String actual = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[6]/div/small[2]")).getText();

        StringUtility.verifyEquals(expected, actual);

        driver.quit();
    }
}
