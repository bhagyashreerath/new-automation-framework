package com.framework.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver(String browser) {

        try {
            ChromeOptions options = new ChromeOptions();

            if (browser.equalsIgnoreCase("chrome")) {
                driver.set(
                        new RemoteWebDriver(
                                new URL("http://localhost:4444/wd/hub"),
                                options
                        )
                );
            }

            getDriver().manage().window().maximize();
            getDriver().manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(10));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
