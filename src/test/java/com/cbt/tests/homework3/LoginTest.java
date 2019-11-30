package com.cbt.tests.homework3;

import com.cbt.tests.TestBase;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test
    public void test1(){

        // read url value from the properties file
        String url = ConfigurationReader.getProperty("url");
        Driver.get().get(url);

       // Driver.get().getTitle();

        BrowserUtils.wait(2);
        Driver.close();
    }

}
