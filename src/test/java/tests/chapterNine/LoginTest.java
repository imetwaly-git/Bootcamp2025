package tests.chapterNine;

import org.testng.annotations.Test;
import tests.TestShopScenario;
import tests.pages.AuthenticationPage;
import tests.pages.HeaderPage;

import static org.testng.Assert.assertTrue;

public class LoginTest extends TestShopScenario {
    @Test
    public void logIn(){
        HeaderPage headerPage = new HeaderPage(driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);

        headerPage.clickOnSignIn();

        authenticationPage.logIn("ibrahim.metwaly@polteq.com", "12345");
        assertTrue(headerPage.signOutButtonPresent(), "Log out button is not visible");
    }
}
