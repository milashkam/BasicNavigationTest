package com.cbt.tests.homework1;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase_3 {

    public static void main(String[] args) {

        // Step 1. Go to https://practice-cybertekschool.herokuapp.com
        // Step 2. Click on “Multiple Buttons”
        // Step 3. Click on “Button 1”
        // Verify that result message is displayed: “Clicked on button one!"

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Multiple Buttons")).click();

        driver.findElement(By.tagName("button")).click();

        String actualresult = driver.findElement(By.id("result")).getText();
        String expectedresult = "Clicked on button one!";

        StringUtility.verifyEquals(expectedresult, actualresult);

       // System.out.println(result.getText() );

        driver.quit();

    }
}
