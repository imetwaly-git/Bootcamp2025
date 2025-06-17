package com.polteq.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.polteq.lib.DriverFactory;
import com.polteq.pages.AuthenticationPage;
import com.polteq.pages.ContactUsPage;
import com.polteq.pages.HeaderPage;

import java.time.Duration;

public class TestShopScenario {

   protected WebDriver driver;
   protected WebDriverWait wait;
   protected HeaderPage headerPage;
   protected AuthenticationPage authenticationPage;
   protected ContactUsPage contactUsPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver(DriverFactory.BrowserType.FIREFOX);
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
