package tests.chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.*;
import static org.testng.Assert.*;
import java.util.List;

public class SignOutTest extends TestShopScenario  {

    String email = "ibrahim.metwaly@polteq.com";
    String pwd = "12345";
    String expectedName = "Ibrahim Metwaly";

    @Test
    public void signOutTest() {
        driver.findElement(By.className("login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(pwd);
        driver.findElement(By.id("SubmitLogin")).click();

        //testNG
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logout")));
        assertTrue(logoutButton.isDisplayed(), "\nLog out button is not visible");
        System.out.print("\nLog out button is present");

        //assertj
        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account")));
        assertThat(name.getText()).as("Displayed username").isEqualTo(expectedName);
        System.out.println("\nExpected name is present:" + " " + name.getText());

        //signout
        driver.findElement(By.className("logout")).click();

        //Assertj, use findelements instead of isDisplayed
        List<WebElement> loginArray = driver.findElements(By.className("login"));
        assertThat(loginArray).as("Expect only 1 element").hasSize(1);
        System.out.print("\nLog in button is present");

    }
}
