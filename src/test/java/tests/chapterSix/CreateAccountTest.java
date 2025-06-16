package tests.chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAccountTest extends TestShopScenario {

    @Test
    public void createUser(){
        String name = "Createusertest";
        driver.findElement(By.className("login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create"))).sendKeys(randomEmail());
        driver.findElement(By.id("SubmitCreate")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1"))).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(name);
        driver.findElement(By.id("customer_lastname")).sendKeys(name + "LastName");
        driver.findElement(By.id("passwd")).sendKeys(name);

        driver.findElement(By.id("submitAccount")).click();

        WebElement createdUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account")));
        assertThat(createdUserName.getText()).as("Displayed username").isEqualTo(name + " " + name + "LastName");
    }

    private String randomEmail (){
        return "ibrahim.metwaly" + System.currentTimeMillis() + "@polteq.com";
    }
}
