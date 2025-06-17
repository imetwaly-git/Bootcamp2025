package com.polteq.steps;

import com.polteq.lib.DriverFactory;
import com.polteq.pages.AuthenticationPage;
import com.polteq.pages.HeaderPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class StepDefinitions {

    private WebDriver driver;
    private AuthenticationPage authenticationPage;
    private HeaderPage headerPage;

    protected static final String TEST_USER = "ibrahim.metwaly@polteq.com";
    protected static final String TEST_USER_PASSWORD  = "12345";

    @Before
    public void setUp() {
        driver = DriverFactory.createDriver(DriverFactory.BrowserType.FIREFOX);
        authenticationPage = new AuthenticationPage(driver);
        headerPage = new HeaderPage(driver);
        driver.manage().window().maximize();
    }

    @Given("I am on the Polteq great testshop")
    public void iAmOnThePolteqGreatTestshop() {
        driver.get("https://greatshop.polteq-testing.com");
    }

    @When("I log in as a valid user")
    public void iLogInAsAValidUser() {
        headerPage.clickOnSignIn();
        authenticationPage.logIn(TEST_USER, TEST_USER_PASSWORD);
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        assertTrue(headerPage.signOutButtonPresent());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
