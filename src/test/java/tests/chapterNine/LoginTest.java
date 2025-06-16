package tests.chapterNine;
import org.testng.annotations.Test;
import tests.TestShopScenario;
import static org.testng.Assert.assertTrue;

public class LoginTest extends TestShopScenario {
    @Test
    public void logIn(){
        headerPage.clickOnSignIn();
        authenticationPage.logIn("ibrahim.metwaly@polteq.com", "12345");
        assertTrue(headerPage.signOutButtonPresent(), "Log out button is not visible");
    }
}
