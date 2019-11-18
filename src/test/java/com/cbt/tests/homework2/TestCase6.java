package com.cbt.tests.homework2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
       // driver.get("https://practice-cybertekschool.herokuapp.com/");

    }
    @Test
    public void TestCase6(){

        driver.get("https://www.tempmailaddress.com/");
        // copy and save temp email
        String tempemail = driver.findElement(By.id("email")).getText();

        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();

        driver.findElement(By.name("full_name")).sendKeys("Mahriban Gurbanova");
        driver.findElement(By.name("email")).sendKeys(tempemail);

        driver.findElement(By.name("wooden_spoon")).click();
        //Verify that Sign Up message is displayed
        String buttonactual = driver.findElement(By.tagName("h3")).getText();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";

        Assert.assertEquals(expected, buttonactual, "message is not correct");

        WebElement message =  driver.findElement(By.tagName("h3"));
        Assert.assertTrue(message.isDisplayed(), "message is not displayed");

        driver.navigate().to("https://www.tempmailaddress.com/");
        BrowserUtils.wait(2);

        String actual1=driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[3]/td[1]/span[2]")).getText();
        String expected1="do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(expected1,actual1,"Something wrong2");

        driver.findElement(By.xpath("//*[@id='schranka']/tr[3]/td[1]/span[2]")).click();  //11 step

        String actual2= driver.findElement(By.id("odesilatel")).getText();
        String expected2 = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actual2, expected2, "something wrong with email actual2");

        String actualsubject = driver.findElement(By.id("predmet")).getText();
        String expectedsubject = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualsubject, expectedsubject, "Subject is not match");

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
