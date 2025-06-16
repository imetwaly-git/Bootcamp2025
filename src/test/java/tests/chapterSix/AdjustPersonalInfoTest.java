package tests.chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import tests.TestShopScenario;

import static java.util.Objects.isNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class AdjustPersonalInfoTest extends TestShopScenario {
    String email = "ibrahim.metwaly@polteq.com";
    String pwd = "12345";
    String firstName1 = "Ibrahim";
    String lastName1 = "Metwaly";
    String firstName2 = "Miharbi";
    String lastName2 = "EddyWally";

    @Test
    public void changeInfo(){
        logIn();
        changeName();
    }

    private void logIn(){
        driver.findElement(By.className("login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(pwd);
        driver.findElement(By.id("SubmitLogin")).click();

        //testNG
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logout")));
        assertTrue(logoutButton.isDisplayed(), "Log out button is not visible");
        System.out.print("Log out button is present, so user is logged in");
    }

    private void changeName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("icon-user"))).click();

        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
        WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastname")));
        String firstNameText = firstName.getAttribute("value");
        if(isNull(firstNameText)){
            firstNameText = "";
        }
        String lastNameText = lastName.getAttribute("value");
        if(isNull(lastNameText)){
            lastNameText = "";
        }
        System.out.println("\nCurrent name is:" + " " + firstNameText + " " + lastNameText);

        if(firstNameText.equalsIgnoreCase(firstName1) && lastNameText.equalsIgnoreCase(lastName1)){
            firstName.clear();
            firstName.sendKeys(firstName2);
            lastName.clear();
            lastName.sendKeys(lastName2);

            driver.findElement(By.id("old_passwd")).sendKeys(pwd);

            driver.findElement(By.cssSelector("button[name='submitIdentity']")).click();

            assertThat(checkName()).as("Displayed username").isEqualTo(firstName2 + " " + lastName2);
            System.out.println("New name is:" + " " + checkName());
        }
        else {
            firstName.clear();
            firstName.sendKeys(firstName1);

            lastName.clear();
            lastName.sendKeys(lastName1);

            driver.findElement(By.id("old_passwd")).sendKeys(pwd);

            driver.findElement(By.cssSelector("button[name='submitIdentity']")).click();

            assertThat(checkName()).as("Displayed username").isEqualTo(firstName1 + " " + lastName1);
            System.out.println("New name is" + " " + checkName());
        }
    }

    private String checkName(){
        WebElement fullNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account")));
        return fullNameElement.getText();
    }
}
