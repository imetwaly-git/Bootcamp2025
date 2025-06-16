package tests.chapterNine;

import org.testng.annotations.Test;
import tests.TestShopScenario;
import tests.pages.ContactUsPage;
import tests.pages.HeaderPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactUsTest extends TestShopScenario {

    @Test
    public void submitContactUs(){
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);

        headerPage.clickOnContactUs();

        contactUsPage.selectASubjectHeading("Customer Service");
        contactUsPage.fillInEmailAndClick("ibrahim.metwaly@polteq.com");
        contactUsPage.fillInOrderID("21345");
        contactUsPage.fillInMessage("This is a message");
        contactUsPage.sendTicket();

        assertThat(contactUsPage.getValidationMessage()).as("Displayed validaton").contains("successfully");

    }
}
