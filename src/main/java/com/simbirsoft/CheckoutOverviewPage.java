package com.simbirsoft;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends WebPage {

    public CheckoutOverviewPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[name=finish]")
    private WebElement finishButton;

    @Step("Нажатие на кнопку Finish")
    public void clickToFinishButton() {
        finishButton.click();
    }
}
