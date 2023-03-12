package com.simbirsoft;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends WebPage {

    public CheckoutCompletePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h2[class=complete-header]")
    private WebElement completeText;

    public WebElement getCompleteText() {
        return completeText;
    }
}
