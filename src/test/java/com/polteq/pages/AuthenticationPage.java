package com.polteq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthenticationPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailInputField;

    @FindBy(id = "passwd")
    private WebElement passwordInputField;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    public void logIn(String email, String password){
        wait.until(ExpectedConditions.visibilityOf(emailInputField));
        emailInputField.sendKeys(email);
        passwordInputField.sendKeys(password);
        loginButton.click();
    }

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }
}
