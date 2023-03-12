package com.simbirsoft;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends WebPage {
    @FindBy(xpath = "//*[contains(@name,'add-to-cart')]")
    private WebElement addToCardButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement basketButton;

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }


    @Step("Добавление первого продукта в корзину")
    public void clickToAddToCardButton() {
        addToCardButton.click();
    }

    @Step("Переход в корзину")
    public void clickToBasketButton() {
        basketButton.click();
    }
}
