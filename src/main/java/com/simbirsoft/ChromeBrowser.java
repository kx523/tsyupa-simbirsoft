package com.simbirsoft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {
    public WebDriver webDriver;

    public ChromeBrowser() {
        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
        this.webDriver = new ChromeDriver();

        webDriver.get("https://www.saucedemo.com/");
    }
}
