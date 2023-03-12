package com.simbirsoft;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage extends WebPage {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "h3[data-test=error]")
    private WebElement error;

    public AuthorizationPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getError() {
        return error;
    }

    @Step("Выполнение авторизации с данными: {userName}, {password}")
    public void authorization(String userName, String password) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
