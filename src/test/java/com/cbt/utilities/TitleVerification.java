package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

         WebDriver driver = BrowserFactory.getDriver("chrome");

         driver.get(urls.get(0));
         driver.get(urls.get(1));
         driver.get(urls.get(2));

         if(urls.get(0).startsWith("http://practice.cybertekschool.com")){
             System.out.println("passed");
         }if(urls.get(1).startsWith("http://practice.cybertekschool.com")){
            System.out.println("pass yes");
        }if(urls.get(2).startsWith("http://practice.cybertekschool.com")){
            System.out.println("pass yuhuu");
        }else{
            System.out.println("fail");
        }

         driver.close();
    }

}
