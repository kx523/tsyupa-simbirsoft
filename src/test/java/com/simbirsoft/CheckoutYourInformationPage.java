package com.simbirsoft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutYourInformationPage {
    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;
    @FindBy(id = "postal-code")
    private WebElement zipCode;
    @FindBy(id = "continue")
    private WebElement continueButton;
    private WebDriver webDriver;

    public CheckoutYourInformationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public void setFirstName(String name) {
        firstName.sendKeys(name);
    }
    public void setLastName(String name) {
        lastName.sendKeys(name);
    }
    public void setZipCode(String name) {
        zipCode.sendKeys(name);
    }
    public void clickContinueButton() {
        continueButton.click();
    }
}
