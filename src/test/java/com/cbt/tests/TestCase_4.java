package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase_4 {

    public static void main(String[] args) {

        //Step 1. Go to https://practice-cybertekschool.herokuapp.com
        // Step 2. Click on “Registration Form”
        // Step 3. Enter “123” into first name input box.
        // Step 4. Verify that warning message is displayed: “first name can only consist of alphabetical letters”

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Registration Form")).click();

        driver.findElement(By.name("firstname")).sendKeys("1234");

        String actualresult=driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[3]")).getText();
        String expectedresult="first name can only consist of alphabetical letters";

        StringUtility.verifyEquals( actualresult, expectedresult);

        driver.close();
    }
}
