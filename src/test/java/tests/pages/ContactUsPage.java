package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends BasePage {

    @FindBy(css = "input#email")
    private WebElement emailTextField;

    @FindBy(css = "input#id_order")
    private WebElement orderIdTextField;

    @FindBy(css = "textarea#message")
    private WebElement messageTextField;

    @FindBy(css = "button#submitMessage")
    private WebElement sendButton;

    @FindBy(css = ".alert.alert-danger>ol>li")
    private WebElement invalidEmailElement;

    @FindBy(css = ".alert.alert-success")
    private WebElement ticketSubmittedBanner;

    private static final String subjectHeadingSelectBoxLocatorText = "id_contact";
    private final By subjectHeadingSelectBoxByLocator = By.id(subjectHeadingSelectBoxLocatorText);
    @FindBy(id = subjectHeadingSelectBoxLocatorText) //both by and findby locator
    private WebElement subjectHeadingSelectBox;

    public void fillInEmailAndClick(String email){
        wait.until(ExpectedConditions.visibilityOf(emailTextField));
        emailTextField.sendKeys(email);
        orderIdTextField.click();
    }

    public void selectASubjectHeading(String subjectHeading){
        wait.until(ExpectedConditions.presenceOfElementLocated(subjectHeadingSelectBoxByLocator));
        Select contactSelect = new Select(subjectHeadingSelectBox);
        contactSelect.selectByVisibleText(subjectHeading);
    }

    public void fillInMessage(String inputMessage){
        wait.until(ExpectedConditions.visibilityOf(messageTextField));
        messageTextField.sendKeys(inputMessage);
    }

    public void fillInOrderID(String orderID){
        wait.until(ExpectedConditions.visibilityOf(orderIdTextField));
        orderIdTextField.sendKeys(orderID);
    }

    public void sendTicket(){
        wait.until(ExpectedConditions.visibilityOf(sendButton));
        sendButton.click();
    }

    public String getValidationMessage(){
        wait.until(ExpectedConditions.visibilityOf(ticketSubmittedBanner));
        return ticketSubmittedBanner.getText();
    }

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

}
