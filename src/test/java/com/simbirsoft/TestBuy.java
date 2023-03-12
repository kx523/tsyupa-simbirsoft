package com.simbirsoft;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBuy {
    public WebDriver webDriver;
    public AuthorizationPage authorizationPage;


    @Before
    public void setUp() throws IOException {
        loadProperties();
        setupDriver();
        authorizationPage = new AuthorizationPage();
        // Открыть ссылку
        webDriver.get(System.getProperty("site.url"));
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
        authorizationPage.authorization(System.getProperty("user"),System.getProperty("password"));
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

    // Читаем конфигурационные файлы в System.properties
    private void loadProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
    }

    private void setupDriver() {
        // Создание экземпляра драйвера
        webDriver = new ChromeDriver();
        // Устанавливаем размер окна браузера, как максимально возможный
        webDriver.manage().window().maximize();
        // Установим время ожидания для поиска элементов
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Установить созданный драйвер для поиска в веб-страницах
        WebPage.setDriver(webDriver);
    }

    @After
    public void closeBrowser() {
        webDriver.quit();
    }
}
