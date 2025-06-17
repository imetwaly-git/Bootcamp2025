package tests.dataDriven;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.TestShopScenario;


import static org.assertj.core.api.Assertions.assertThat;

public class DataDrivenTest extends TestShopScenario {

    @Parameters({"subject", "email", "orderID", "message"})
    @Test
    public void submitContactUs(String subject, String email, String orderID, String message){
        headerPage.clickOnContactUs();

        contactUsPage.selectASubjectHeading(subject);
        contactUsPage.fillInEmailAndClick(email);
        contactUsPage.fillInOrderID(orderID);
        contactUsPage.fillInMessage(message);
        contactUsPage.sendTicket();

        assertThat(contactUsPage.getValidationMessage()).as("Displayed validaton").contains("successfully");

    }
}
