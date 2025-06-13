package tests.chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class FillCartTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://greatshop.polteq-testing.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void addToCart(){
        //check if cart is empty
        WebElement cartEmpty = driver.findElement(By.className("ajax_cart_no_product"));
        assertTrue(cartEmpty.isDisplayed(), "Cart is not empty");
        System.out.println("Starting with an empty cart");

        driver.findElement(By.cssSelector("[title=\"More about ipod\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space(text())='iPod shuffle']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_to_cart"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(@title)='Continue shopping']"))).click();

        WebElement cartAdded = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart .ajax_cart_quantity")));
        assertThat(cartAdded.getText()).as("Amount in cart").isEqualTo("1");
        System.out.println("\nThe following amount is added to the cart:" + " " + cartAdded.getText());

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
