package com.simbirsoft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[contains(@name,'add-to-cart')]")
    private WebElement addToCardButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement basketButton;

    public ProductsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickAddToCardButton() {
        addToCardButton.click();
    }

    public void clickBasket() {
        basketButton.click();
    }

}
