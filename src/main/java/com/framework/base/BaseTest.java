package com.framework.base;

import org.openqa.selenium.WebDriver;

import com.framework.factory.DriverFactory;

public class BaseTest {

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
}
