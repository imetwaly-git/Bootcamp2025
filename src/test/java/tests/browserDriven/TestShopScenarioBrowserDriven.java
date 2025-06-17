package tests.browserDriven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import tests.lib.DriverFactory;
import tests.pages.AuthenticationPage;
import tests.pages.ContactUsPage;
import tests.pages.HeaderPage;

import java.time.Duration;

public class TestShopScenarioBrowserDriven {

   protected WebDriver driver;
   protected WebDriverWait wait;
   protected HeaderPage headerPage;
   protected AuthenticationPage authenticationPage;
   protected ContactUsPage contactUsPage;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(DriverFactory.BrowserType browserType) {
       // driver = DriverFactory.createDriver(DriverFactory.BrowserType.FIREFOX);
        driver = DriverFactory.createDriver(browserType);
        headerPage = new HeaderPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        contactUsPage = new ContactUsPage(driver);
        driver.get("https://greatshop.polteq-testing.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //overruled implicitly
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //standard on all
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
