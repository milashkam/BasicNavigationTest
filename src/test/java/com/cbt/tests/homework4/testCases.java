package com.cbt.tests.homework4;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class testCases {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {

        driver = BrowserFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
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
    public void teardown() {
        driver.quit();
    }

    //     //tbody//tr[13]/td[9]/div/div/a
    @Test(description = "Verify ... contains edit, delete, view options")
    public void test1() {

        Actions action = new Actions(driver);
        WebElement threeDots = driver.findElement(By.xpath("//tbody/tr[13]/td[9]/div/div/a"));
        action.moveToElement(threeDots).perform();
        BrowserUtils.wait(2);
        action.moveToElement(threeDots.findElement(By.xpath("//i[@class='fa-eye hide-text']"))).perform();
        BrowserUtils.wait(1);
        action.moveToElement(threeDots.findElement(By.xpath("//i[@class='fa-pencil-square-o hide-text']"))).perform();
        BrowserUtils.wait(1);
        action.moveToElement(threeDots.findElement(By.xpath("//i[@class='fa-trash-o hide-text']"))).perform();
        BrowserUtils.wait(2);
//        WebElement ThreeDot = driver.findElement(By.xpath("//tbody//tr[13]/td[9]/div/div/a"));
//        action.moveToElement(ThreeDot).perform();
//        BrowserUtils.wait(2);
//        WebElement textOfView = driver.findElement(By.cssSelector("[class=\"fa-eye hide-text\"]"));
//        action.moveToElement(textOfView).perform();
//        BrowserUtils.wait(2);
//        Assert.assertTrue(textOfView.isDisplayed());
////   [class="fa-pencil-square-o hide-text"]:nth-of-type
//        WebElement edit = driver.findElement(By.xpath("//i[@class=\"fa-pencil-square-o hide-text\"]"));
//        action.moveToElement(edit).perform();
//        BrowserUtils.wait(2);
//        WebElement delete = driver.findElement(By.xpath("//i[@class=\"fa-trash-o hide-text\"]"));
//        action.moveToElement(delete).perform();
//        BrowserUtils.wait(2);

    }

    @Test
    public void test2() {

        driver.findElement(By.cssSelector("[class=\"fa-cog hide-text\"]")).click();
// //tbody[@class="ui-sortable"]/tr/td[3]

        List<WebElement> gridList = driver.findElements(By.xpath("//tbody[@class=\"ui-sortable\"]/tr/td[3]"));
        for (int i = 1; i < gridList.size(); i++) {
            gridList.get(i).click();
            Assert.assertFalse(gridList.get(i).isSelected());
        }

        WebElement titleColumn = driver.findElement(By.xpath("//span[@class='grid-header-cell__label'][contains(text(),'Title')][1]"));
        Assert.assertTrue(titleColumn.isDisplayed(), "Title column is not displayed");

    }

    @Test(description = "Verify that “Save And Close”, “Save And New” and “Save” options are available")
    public void test3() {

        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        WebElement saveAndCloseButton = driver.findElement(By.cssSelector("a[class='btn-success btn dropdown-toggle'']"));
        BrowserUtils.wait(2);
        saveAndCloseButton.click();
        List<WebElement> options = driver.findElements(By.xpath("//li/button"));
        for (WebElement option : options
        ) {
            option.isEnabled();
            System.out.println(option.getText());
        }
        BrowserUtils.wait(3);
    }

    @Test(description = "Verify that “All Calendar Events” page subtitle is displayed")
    public void test4() {

        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        WebElement cancelButton = driver.findElement(By.xpath("//a[@title='Cancel']"));
        BrowserUtils.wait(2);
        cancelButton.click();
        BrowserUtils.wait(2);

        String expectedSubtitle = "All Calendar Events";
        String actualSub = driver.findElement(By.className("oro-subtitle")).getText();
        System.out.println(actualSub);
        // .oro-subtitle
        Assert.assertEquals(actualSub, expectedSubtitle, "Subtitle is wrong");

    }

    @Test(description = "Verify that difference between end and start time is exactly 1 hour")
    public void test5() {

        driver.findElement(By.cssSelector("[title='Create Calendar event']")).click();
        WebElement loaderMask =  driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        WebElement StartTime =  driver.findElement(By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input']"));
        StartTime.click();

        driver.findElement(By.xpath("//li[contains(text(),'12:00 AM')]")).click();
        driver.findElement(By.cssSelector("[class='input-small timepicker-input end ui-timepicker-input']")).click();
        WebElement EndTime = driver.findElement(By.cssSelector("[class='ui-timepicker-am ui-timepicker-selected']:nth-of-type(3)"));
        String actuslEndTime = EndTime.getText();
        String expectedEndTime = "1:00 AM";
        Assert.assertTrue(EndTime.isDisplayed());
        Assert.assertEquals(actuslEndTime,expectedEndTime, "Start time and end time are not 1 hour apart");

    }

    @Test(description = "Verify that end time is equals to 10:00pm when 9:00 PM start time is selected")
    public void testCase6(){
        driver.findElement(By.cssSelector("[title='Create Calendar event']")).click();
        WebElement loaderMask =  driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        WebElement StartTime =  driver.findElement(By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input']"));
        StartTime.click();
        driver.findElement(By.xpath("//li[contains(text(),'9:00 PM')]")).click();
        driver.findElement(By.cssSelector("[class='input-small timepicker-input end ui-timepicker-input']")).click();
        WebElement EndTime =  driver.findElement(By.cssSelector("[class='ui-timepicker-pm ui-timepicker-selected']:nth-of-type(3)"));
        String actuslEndTime = EndTime.getText();
        String expectedEndTime = "10:00 PM";
        Assert.assertTrue(EndTime.isDisplayed());
        Assert.assertEquals(actuslEndTime,expectedEndTime, "Start time and end time are not 1 hour apart");

    }

    @Test (description = "Verify that 'All-Day Event' is selected and start/end time slots are not displayed")
    public void  test7(){

        driver.findElement(By.cssSelector("[title='Create Calendar event']")).click();
        WebElement loaderMask =  driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        WebElement allDayButton = driver.findElement(By.cssSelector("[data-name='field__all-day']"));
        allDayButton.click();
        BrowserUtils.wait(2);
        Assert.assertTrue(allDayButton.isSelected(), "All day event button is not selected");

        WebElement StartTime = driver.findElement(By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input']"));
        WebElement EndTime =  driver.findElement(By.cssSelector("[class='input-small timepicker-input end ui-timepicker-input']"));

        Assert.assertFalse(StartTime.isDisplayed(), "Start time is displayed");
        Assert.assertFalse(EndTime.isDisplayed(), "End time is displayed");
    }

    @Test(description = "Verify that “Repeat” checkbox is selected7.Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down:")
    public void test8() {

        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        WebElement repeatBox = driver.findElement(By.xpath("//input[@data-name=\"recurrence-repeat\"]"));
        repeatBox.click();
        Assert.assertTrue(repeatBox.isSelected(), "Is not selected");
//  /following-sibling::div"));

        WebElement repeatBox1 = driver.findElement(By.xpath("//div[@data-name='recurrence-settings']/div/div/div/select"));
        Select select = new Select(repeatBox1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Daily");
        BrowserUtils.wait(3);
        repeatBox1.click();

        List<WebElement> list = driver.findElements(By.xpath("//select[@name='temp-validation-name-125']/option"));
        for (int i = 0; i < list.size(); i++) {
            list.get(i).isEnabled();


        }
    }

    @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day")
    public void test9(){

        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        WebElement repeatBox = driver.findElement(By.xpath("//input[@data-name=\"recurrence-repeat\"]"));
        repeatBox.click();
        Assert.assertTrue(repeatBox.isSelected(), "Is not selected");

        WebElement RepeatEveryButton = driver.findElement(By.xpath("//span[text()='day(s)']/preceding-sibling :: input[3]"));
        Assert.assertTrue( RepeatEveryButton.isSelected());

        WebElement neverButton = driver.findElement(By.xpath("//span[text()='day(s)']/preceding-sibling :: input[3]"));
        Assert.assertTrue(neverButton.isSelected() );

        WebElement summary = driver.findElement(By.xpath("//span[text()='Daily every 1 day']"));
        Assert.assertTrue(summary.isDisplayed());
    }


    @Test (description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day, endafter 10 occurrences")
    public  void test10(){
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        WebElement repeatBox = driver.findElement(By.xpath("//input[@data-name=\"recurrence-repeat\"]"));
        BrowserUtils.wait(3);
        repeatBox.click();

        //click "After" radio button
        driver.findElement(By.xpath("//span[text()='After']/preceding-sibling :: input")).click();
        //send 10 into occurrence box
        driver.findElement(By.xpath("//span[text()='After']/following-sibling :: input")).sendKeys("10",Keys.ENTER);
        String expectedMessage = "Daily every 1 day, end after 10 occurrences";
        String actualMessage = driver.findElement(By.xpath("//div[@data-name='recurrence-summary']/div")).getText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage);
        ////div[@data-name="recurrence-summary"]/div/span

}

@Test (description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”")
        public void test11(){

    driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
    WebElement repeatBox = driver.findElement(By.xpath("//input[@data-name=\"recurrence-repeat\"]"));
    BrowserUtils.wait(3);
    repeatBox.click();

    //Click "By" button
    driver.findElement(By.xpath("//span[text()='By']/preceding-sibling :: input")).click();
    driver.findElement(By.xpath("//span[text()='By']/parent :: label/following-sibling :: span/div/input[2]")).click();

    WebElement monthName = driver.findElement(By.className("ui-datepicker-month"));
    Select select = new Select(monthName);
    select.selectByValue("10");

    WebElement year = driver.findElement(By.className("ui-datepicker-year"));
    Select select1 = new Select(year);
    select1.selectByValue("2021");
  // BrowserUtils.wait(3);
    driver.findElement(By.xpath("//table/tbody/tr[3]/td[5]/a")).click();
    // BrowserUtils.wait(3);
    String expectedMessage = "Daily every 1 day, end by Nov 18, 2021";
    String actualMessage = driver.findElement(By.xpath("//div[@data-name='recurrence-summary']/div")).getText();
    System.out.println(actualMessage);
    Assert.assertEquals(actualMessage,expectedMessage);


}
    @Test (description = "Verify that “Monday and Friday” options are selected9.Verify that following message as a summary is displayed: “Summary: Weekly every 1 week onMonday, Friday”")
    public void test12(){

        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        WebElement repeatBox = driver.findElement(By.xpath("//input[@data-name=\"recurrence-repeat\"]"));
        BrowserUtils.wait(3);
        repeatBox.click();


        WebElement repeatBox1 = driver.findElement(By.xpath("//div[@data-name='recurrence-settings']/div/div/div/select"));
        repeatBox1.click();
        BrowserUtils.wait(3);

       Select select = new Select(repeatBox1);
       select.selectByValue("weekly");

      WebElement monday =  driver.findElement(By.cssSelector("input[value=\"monday\"]"));
      monday.click();
        BrowserUtils.wait(3);
       Assert.assertTrue(monday.isSelected());
        WebElement friday =  driver.findElement(By.cssSelector("input[value=\"friday\"]"));
                friday.click();
                Assert.assertTrue(friday.isSelected());

    }
}
