package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tests.lib.DriverFactory;
import tests.pages.AuthenticationPage;
import tests.pages.HeaderPage;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class TestShopScenario {

   protected WebDriver driver;
   protected WebDriverWait wait;
   protected HeaderPage headerPage;
   protected AuthenticationPage authenticationPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver(DriverFactory.BrowserType.FIREFOX);
        headerPage = new HeaderPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        driver.get("https://greatshop.polteq-testing.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //overruled implicitly
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //standard on all
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
