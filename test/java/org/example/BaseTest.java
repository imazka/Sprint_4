package org.example;

import org.example.page.StartPageObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;

    protected static WebDriver getDriver(String driverType) {
        switch (driverType) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Driver type is not supported");
        }
    }

    protected static void setCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
    }
}
