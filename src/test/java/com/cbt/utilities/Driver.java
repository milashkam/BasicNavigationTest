package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver;
    //    you cannot do like this, if constructor is private Driver obj = new Driver()
    private Driver() {
    }
    public static WebDriver get() {

        if (driver == null) {
            String browser = ConfigurationReader.getProperty("browser");
            if ("chrome".equals(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if ("firefox".equals(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {//if browser type is wrong, stop tests and throw exception,
                // no browser will be opened
                throw new RuntimeException("Wrong browser type!");
            }
        }

        //if Webdriver
        return driver;
    }

    public static void close(){
        //if driver still exist
        if (driver != null) {
            //close all browsers
            driver.quit();
            //destroy driver object, ready for gc
            driver = null;
        }
    }
}
