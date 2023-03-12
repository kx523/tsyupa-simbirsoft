package com.simbirsoft;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage extends WebPage {

    public YourCartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[name=checkout]")
    private WebElement checkoutButton;

    @Step("Нажатие на кнопку Checkout")
    public void clickCheckout() {
        checkoutButton.click();
    }
}
