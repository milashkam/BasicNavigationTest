package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {

    public static void main(String[] args) throws InterruptedException {

//        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
//                "https://wayfair.com/", "https://walmart.com" , "https://www.westelm.com/");
//
//        WebDriver driver = BrowserFactory.getDriver("chrome");
//
//        driver.get(urls.get(0));
//        String actualTitle1 =  driver.getTitle().toLowerCase().replaceAll(".", "");
//        driver.get(urls.get(1));
//        String actualTitle2 =  driver.getTitle().toLowerCase().replaceAll(".", "");
//        driver.get(urls.get(2));
//       // driver.wait(1000);
//        String actualTitle3 =  driver.getTitle().toLowerCase().replaceAll(".", "");
//
//        driver.get(urls.get(3));
//        String actualTitle4 = driver.getTitle().toLowerCase().replaceAll(".", "");
//
//        if(urls.get(0).contains(actualTitle1)){
//            System.out.println("pass yeahh");
//        }if(urls.get(1).contains(actualTitle2)){
//            System.out.println("pass boldy");
//        }if(urls.get(2).contains(actualTitle3)){
//            System.out.println("pass etdi");
//        }if(urls.get(3).contains(actualTitle4)){
//            System.out.println("passed");
//        }
//        else{
//            System.out.println("fail ufffff");
//        }
//        driver.close();
//

        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com" , "https://www.westelm.com/");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        for(int i=0; i<urls.size(); i++) {
            driver.get(urls.get(i));
            String actualTitle1 = driver.getTitle().toLowerCase().replaceAll(".", "");

            if (urls.get(i).contains(actualTitle1)) {
                System.out.println("pass yeahh"+i );
            }

            else {
                System.out.println("fail ufffff");
            }
        }
        driver.close();


    }
}
