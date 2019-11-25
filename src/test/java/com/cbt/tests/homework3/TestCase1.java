package com.cbt.tests.homework3;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase1 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){

        driver = BrowserFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager55");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        // driver.findElement(By.id("_submit")).click();

        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        BrowserUtils.wait(3);
        activitiesElement.click();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();
        // BrowserUtils.wait(3);
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test (description = "Verify that page subtitle \"Options\" is displayed")
    public void test1(){

        WebElement options = driver.findElement(By.cssSelector("[class=\"btn btn-link dropdown-toggle\"]"));
        Assert.assertTrue(options.isDisplayed(), "Options not displayed");
    }
    @Test (description = "Verify that page number is equals to \"1\"")
    public void test2(){

        String pageNumber = driver.findElement(By.cssSelector("[type='number']")).getAttribute("value");
        Assert.assertEquals(pageNumber, "1", "Not equal to 1");
    }
    @Test (description = "Verify that view per page number is equals to \"25\"")
    public void test3(){

        String actualViewPerPage = driver.findElement(By.xpath("//div[@class='grid-toolbar clearfix']/div[3]/div[2]/div/div/button")).getText();
        Assert.assertEquals(actualViewPerPage, "25", "Not equal to 25");

    }
}
