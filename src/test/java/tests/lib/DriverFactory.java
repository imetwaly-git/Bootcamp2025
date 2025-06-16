package tests.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public enum BrowserType {CHROME, FIREFOX, EDGE}
    static WebDriver driver;


    public static WebDriver createDriver(BrowserType browserType) {
        switch (browserType) {
            case CHROME -> createChromeDriver();
            case FIREFOX -> createFirefoxDriver();
            case EDGE -> createEdgeDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }

        driver.manage().window().maximize(); // optional
        return driver;
    }

    private static void createFirefoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        //firefoxOptions.addArguments("-private");
        // firefoxOptions.setHeadless(true);
        driver = new FirefoxDriver(firefoxOptions);
    }

    private static void createChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--incognito");
        // chromeOptions.setHeadless(true);
        driver = new ChromeDriver(chromeOptions);
    }

    private static void createEdgeDriver() {
        EdgeOptions edgeOptions = new EdgeOptions();
        //edgeOptions.addArguments("inprivate");
        // edgeOptions.setHeadless(true);
        driver = new EdgeDriver(edgeOptions);
    }
}
