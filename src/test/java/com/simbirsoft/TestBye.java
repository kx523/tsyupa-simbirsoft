package com.simbirsoft;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

    /*
    Предусловие:
    1. Открыть браузер
    2. Перейти на страницу входа: https://www.saucedemo.com/
    3. Заполнить поле Username значением standard_user
    4. Заполнить поле Password значением secret_sauce
    5. Нажать на кнопку LOGIN
    Шаги:
    1. Положить первый продукт в списке на странице PRODUCTS в корзину кнопкой ADD TO CART
    2. Нажать на иконку корзины.
    3. На открывшейся странице корзины нажать кнопку CHECKOUT
    5. На открывшейся странице CHECKOUT: YOUR INFORMATION заполнить поля First Name, Last
Name, Zip Code значением test
    6. Нажать на кнопку CONTINUE
    7. На открывшейся странице CHECKOUT: OVERVIEW нажать кнопку FINISH
    Ожидаемый результат:
    1. Произошел редирект на страницу завершения покупки:
    https://www.saucedemo.com/checkout-complete.html
    2. На странице отображается сообщение: “THANK YOU FOR YOUR ORDER”
     */

public class TestBye {
    public WebDriver webDriver;
    public WebDriverWait wait;
    public AuthorizationPage authorizationPage;
    public ProductsPage productsPage;
    public YourCartPage yourCartPage;
    public CheckoutYourInformationPage checkoutYourInformationPage;
    public CheckoutOverviewPage checkoutOverviewPage;

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
        authorizationPage = new AuthorizationPage(webDriver);
        productsPage = new ProductsPage(webDriver);
        yourCartPage = new YourCartPage(webDriver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(webDriver);
        checkoutOverviewPage = new CheckoutOverviewPage(webDriver);
    }

    // тест - проверка успешной покупки
    @Test
    public void buy() {
        // выполнение авторизации с корректными данными
        authorizationPage.setUsername("standard_user");
        authorizationPage.setPassword("secret_sauce");
        authorizationPage.clickLoginButton();
        // добавление первого продукта в корзину
        productsPage.clickAddToCardButton();
        // переход в корзину
        productsPage.clickBasket();
        // переход на страницу проверки
        yourCartPage.clickChekout();
        // заполнение полей корректными данными
        checkoutYourInformationPage.setFirstName("test");
        checkoutYourInformationPage.setLastName("test");
        checkoutYourInformationPage.setZipCode("test");
        checkoutYourInformationPage.clickContinueButton();
        checkoutOverviewPage.clickFinish();
        /*
           результат:
           редирект на https://www.saucedemo.com/checkout-complete.html
           выводится сообщение "THANK YOU FOR YOUR ORDER"
        */
    }

    // тест - авторизация несуществующего пользователя
    @Test
    public void logIn() {
        // ввод логина и пароля которых не существуют
        authorizationPage.setUsername("test");
        authorizationPage.setPassword("test");
        authorizationPage.clickLoginButton();
        /*
           результат:
           выводится сообщение “Epic sadface: Username and password do not match any user in this service”
        */
    }
}
