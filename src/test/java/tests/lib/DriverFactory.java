package tests.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public enum BrowserType {CHROME, FIREFOX, EDGE}

    public static WebDriver createDriver(BrowserType browserType) {
        WebDriver driver = switch (browserType) {
            case CHROME -> new ChromeDriver();
            case FIREFOX -> new FirefoxDriver();
            case EDGE -> new EdgeDriver();
        };
        driver.manage().window().maximize();
        return driver;
    }
}
