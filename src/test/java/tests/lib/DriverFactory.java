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

    public static WebDriver createDriver(BrowserType browserType) {
        WebDriver driver;

        switch (browserType) {
            case CHROME -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                //chromeOptions.addArguments("--start-maximized");
                //chromeOptions.addArguments("--incognito");
                // chromeOptions.setHeadless(true);
                driver = new ChromeDriver(chromeOptions);
            }

            case FIREFOX -> {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                //firefoxOptions.addArguments("-private");
                // firefoxOptions.setHeadless(true);
                driver = new FirefoxDriver(firefoxOptions);
            }

            case EDGE -> {
                EdgeOptions edgeOptions = new EdgeOptions();
                //edgeOptions.addArguments("inprivate");
                // edgeOptions.setHeadless(true);
                driver = new EdgeDriver(edgeOptions);
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }
        return driver;
    }
}
