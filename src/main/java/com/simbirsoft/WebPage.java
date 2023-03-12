package com.simbirsoft;

import org.openqa.selenium.WebDriver;

public abstract class WebPage {
    protected static WebDriver driver;
    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}
