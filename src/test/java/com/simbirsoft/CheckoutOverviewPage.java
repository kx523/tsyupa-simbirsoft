package com.simbirsoft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {
    public CheckoutOverviewPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    private WebDriver webDriver;

    @FindBy(css = "button[name=finish]")
    private WebElement finish;

    public void clickFinish() {
        finish.click();
    }
}