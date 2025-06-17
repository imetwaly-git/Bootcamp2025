package com.polteq.tests.browserDriven;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import com.polteq.pages.ContactUsPage;
import com.polteq.pages.HeaderPage;

import static org.assertj.core.api.Assertions.assertThat;

public class BrowserDrivenTest extends TestShopScenarioBrowserDriven {

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

    @Test
    public void invalidEmail(){
        headerPage.clickOnContactUs();

        contactUsPage.selectASubjectHeading("Customer Service");
        contactUsPage.fillInEmailAndClick("ibrahim.metwaly.com");
        contactUsPage.fillInOrderID("21345");
        contactUsPage.fillInMessage("This is a message");
        contactUsPage.sendTicket();

        //assertTrue(contactUsPage.invalidEmailMessageVisible(), "Invalid email error is not visible");
        //assertThat(contactUsPage.getInvalidEmailMessageText()).isEqualToIgnoringCase("Invalid email address.");

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(contactUsPage.invalidEmailMessageVisible()).isTrue();
        softly.assertThat(contactUsPage.getInvalidEmailMessageText()).isEqualToIgnoringCase("Invalid email address.");
        softly.assertAll();
    }
}
