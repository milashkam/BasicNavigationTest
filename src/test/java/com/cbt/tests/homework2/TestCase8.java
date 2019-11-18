package com.cbt.tests.homework2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase8 {

    private WebDriver driver;

    @Test
    public void TestCase8(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/"); // step1

        driver.findElement(By.linkText("Autocomplete")).click(); // step2
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");

        driver.findElement(By.cssSelector("input[type='button']")).click();

        String expectMessage = "You selected: United States of America";
        String actualMessage = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(expectMessage, actualMessage, "Message is not correct");

        driver.quit();
    }

}
