package tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HeaderPage extends BasePage {

    @FindBy(id = "contact-link")
    private WebElement contactUsButton;

    @FindBy(className = "account")
    private WebElement accountButton;

    @FindBy(className = "login")
    private WebElement loginButton;

    @FindBy(className = "logout")
    private WebElement logoutButton;

    public void clickOnContactUs(){
        wait.until(ExpectedConditions.visibilityOf(contactUsButton)).click();
    }

    public void clickOnAccount(){
        wait.until(ExpectedConditions.visibilityOf(accountButton)).click();
    }

    public void clickOnSignIn(){
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
    }

    public void clickOnSignOut(){
        wait.until(ExpectedConditions.visibilityOf(logoutButton)).click();
    }

    public HeaderPage(WebDriver driver) {
        super(driver);
    }
}
