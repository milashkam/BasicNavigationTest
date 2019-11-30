package com.cbt.tests;


import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class TestBase {

    @BeforeMethod
    public void setup(){
        String url = ConfigurationReader.getProperty("url");
        Driver.get().get(url);
    }

    @AfterMethod
    public void teardown(){
        Driver.close();
    }

}


