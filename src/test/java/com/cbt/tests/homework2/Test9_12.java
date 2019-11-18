package com.cbt.tests.homework2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test9_12 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
    }


    //Array of different Status Codes
    @DataProvider(name = "testData")
    public static Object[] testData() {
        return new Object[]{"200", "301", "404", "500"};
    }

    @Test(dataProvider = "testData")//  (description= "Verify that the correct status code messages displayed")
    public void StatusCodes(String errorCode) {
        //Click Error code
        WebElement codeNumber = driver.findElement(By.linkText(errorCode));
        codeNumber.click();
        //Verify the displayed Text
        WebElement result = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(result.getText().contains(errorCode), "Wrong Error code");
        //Go back to Status Codes Page
        driver.findElement(By.linkText("here")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
