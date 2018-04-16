package com.virtru.assignment.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverUtils {

    private static WebDriver driverobject;

    public static WebDriver getDriver() {
    
        if (driverobject == null) {
            URL chromeDriverURL = ClassLoader.getSystemClassLoader().getResource("chromedriver");
            System.setProperty("webdriver.chrome.driver", chromeDriverURL.getPath());
            driverobject = new ChromeDriver();
            driverobject.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driverobject;
    }
}
