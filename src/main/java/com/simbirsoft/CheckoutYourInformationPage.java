package com.simbirsoft;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutYourInformationPage extends WebPage {
    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;
    @FindBy(id = "postal-code")
    private WebElement zipCode;
    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutYourInformationPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Заполнение полей First Name, Last Name, Zip Code")
    public void dataInput(String firstName, String lastName, String zipCode) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.zipCode.sendKeys(zipCode);
    }

    @Step("Нажатие на кнопку Continue")
    public void clickToContinueButton() {
        this.continueButton.click();
    }
}
