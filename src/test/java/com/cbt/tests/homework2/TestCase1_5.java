package com.cbt.tests.homework2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1_5 {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
       driver = BrowserFactory.getDriver("chrome");
       driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
    }

@Test (description = "Verify that DOB error message is displayed")
    public void test1(){

        driver.findElement(By.xpath("//input[@name=\"birthday\"]")).sendKeys("wrong_dob");

        String expected = "The date of birth is not valid";

        String actual = driver.findElement(By.xpath("//*[text()='The date of birth is not valid']")).getText();
    //  System.out.println(actual);
       Assert.assertEquals(actual, expected );

    WebElement errorMessage = driver.findElement(By.xpath("//small[@style='display: block;']"));
    Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
    }

    @Test (description = "Verify that c++. java and Javascript is displayed")
    public void TestCase2(){

        WebElement cPlusPlus = driver.findElement(By.cssSelector("label[for='inlineCheckbox1']"));
        Assert.assertTrue(cPlusPlus.isDisplayed(), "C++ is not displayed");

        WebElement java = driver.findElement(By.cssSelector("label[for='inlineCheckbox2']"));
        Assert.assertTrue(java.isDisplayed(), "java is not displayed");

        WebElement JavaScript = driver.findElement(By.cssSelector("label[for='inlineCheckbox3']"));
        Assert.assertTrue( JavaScript.isDisplayed(), "javaScript is not displayed");
    }

    @Test (description = "Verify that invalid input to first name box gives error message")
    public void Testcase3(){

        driver.findElement(By.name("firstname")).sendKeys("M");
        BrowserUtils.wait(2);

        WebElement  errorMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "error message is not displayed");

        String expected = "first name must be more than 2 and less than 64 characters long";
        String actual = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']")).getText();
        Assert.assertEquals(expected, actual, "Warning Message is not correct");
    }

    @Test (description = "Verify that invalid input to last name box gives error message")
    public void TestCase4(){

        driver.findElement(By.name("lastname")).sendKeys("G");
        BrowserUtils.wait(2);

        String expected = "The last name must be more than 2 and less than 64 characters long";
        String actual = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']")).getText();
        Assert.assertEquals(expected, actual, "Warning Message is not correct");

        WebElement errorMessage = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");

    }

    @Test (description = "Verify that after successful sign up verification message is displayed")
    public void TestCase5(){

        driver.findElement(By.name("firstname")).sendKeys("Mahribana");
        BrowserUtils.wait(1);

        driver.findElement(By.name("lastname")).sendKeys("Gurbanova");
        BrowserUtils.wait(1);

        driver.findElement(By.name("username")).sendKeys("Milashka");
        driver.findElement(By.name("email")).sendKeys("gmahriban89@gmail.com");

        driver.findElement(By.name("password")).sendKeys("melekbekir_00");
        driver.findElement(By.name("phone")).sendKeys("832-888-4409");

        driver.findElement(By.cssSelector("input[value='female']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("03/27/1989");

        Select select = new Select(driver.findElement(By.name("department")));
        select.selectByVisibleText("Department of Engineering");

        Select select2 = new Select(driver.findElement(By.name("job_title")));
        select2.selectByVisibleText("SDET");

        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(1);

        WebElement successMessage = driver.findElement(By.xpath("//p[contains(text(),'You')]"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message is Not displayed");

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.xpath("//p[contains(text(),'You')]")).getText();

        Assert.assertEquals(expected, actual, "Message is wrong");
    }


@AfterMethod
    public void teardown(){
        driver.quit();
    }


}
