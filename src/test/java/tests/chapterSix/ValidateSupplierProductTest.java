package tests.chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static org.testng.Assert.assertTrue;

public class ValidateSupplierProductTest extends TestShopScenario {

    @Test
    public void validateAppleStore(){
        WebElement dropdown = driver.findElement(By.name("supplier_list"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("AppleStore");

        List<WebElement> productElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".product_list .product-name")));

        boolean found = productElements.stream().anyMatch(el -> Objects.equals(el.getAttribute("title"), "MacBook Air"));

        assertTrue(found, "'MacBook Air' was not found in the product list.");

        System.out.println("Macbook Air is in the list");

    }
}
