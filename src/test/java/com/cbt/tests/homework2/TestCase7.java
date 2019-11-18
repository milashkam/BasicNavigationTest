package com.cbt.tests.homework2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase7 {

    private WebDriver driver;

    @Test
    public void TestCase7(){

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("File Upload")).click(); // step2
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\agurbanov\\Desktop\\New Text Document.txt");

        driver.findElement(By.id("file-submit")).click(); //step4

        String expectedSubject = "File Uploaded!";
        String actualSubject = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedSubject, actualSubject, "Subjects are not Matching"); // step 5

        WebElement uploaded = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(uploaded.isDisplayed(), "uploaded name is not displayed"); // step6

        driver.quit();



    }
}
