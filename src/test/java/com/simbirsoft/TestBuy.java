package com.simbirsoft;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBuy {
    public WebDriver webDriver;
    public WebDriverWait wait;
    public AuthorizationPage authorizationPage;

    private class Browser extends ChromeBrowser {
        public Browser() {
            super();
        }
    }

    @Before
    public void setUp() {
        webDriver = new Browser().webDriver;
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 5);
        WebPage.setDriver(webDriver);
        authorizationPage = new AuthorizationPage();
    }

    // тест - проверка успешной покупки
    @Test
    public void buyTest() {
        ProductsPage productsPage = new ProductsPage();
        YourCartPage yourCartPage = new YourCartPage();
        CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
        // Предусловие: выполнение авторизации с корректными данными
        authorizationPage.authorization("standard_user", "secret_sauce");
        // Шаг 1. Добавление первого продукта в корзину
        productsPage.clickToAddToCardButton();
        // Шаг 2. Переход в корзину
        productsPage.clickToBasketButton();
        // Шаг 3. Нажатие на кнопку Checkout
        yourCartPage.clickCheckout();
        // Шаг 5. Заполнение полей First Name, Last Name, Zip Code
        checkoutYourInformationPage.dataInput("test", "test", "test");
        // Шаг 6. Нажатие на кнопку Continue
        checkoutYourInformationPage.clickToContinueButton();
        // Шаг 7. Нажатие на кнопку Finish
        checkoutOverviewPage.clickToFinishButton();
        // Ожидаемый результат: редирект на https://www.saucedemo.com/checkout-complete.html
        checkUrl("https://www.saucedemo.com/checkout-complete.html");
        // Ожидаемый результат: выводится сообщение "Thank you for your order!"
        checkText("Thank you for your order!", checkoutCompletePage.getCompleteText());
    }

    // тест - авторизация несуществующего пользователя
    @Test
    public void logInNegativeTest() {
        // Шаг 1. Заполение поля Username значением test
        // Шаг 2. Заполение поля Password значением test
        // Шаг 3. Нажатие на кнопку Login
        authorizationPage.authorization("test", "test");
        // Ожидаемый результат: выводится сообщение “Epic sadface: Username and password do not match any user in this service”
        checkText("Epic sadface: Username and password do not match any user in this service", authorizationPage.getError());

    }

    @Step("Проверка сообщения: {text}")
    public void checkText(String text, WebElement element){
        Assert.assertEquals(text, element.getText());
    }

    @Step("Проверка текущего url: {url}")
    public void checkUrl(String url) {
        Assert.assertEquals(url, webDriver.getCurrentUrl());
    }

    @After
    public void closeBrowser() {
        webDriver.quit();
    }
}
