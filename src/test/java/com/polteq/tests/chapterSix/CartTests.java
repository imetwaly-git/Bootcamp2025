package com.polteq.tests.chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import com.polteq.tests.TestShopScenario;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class CartTests extends TestShopScenario {

    @Test
    public void addToCart(){
        assertCartIsEmpty();
        addIpodToCart();
        assertAddedToCart();
    }

    @Test
    public void deleteFromCart(){
        if (assertCartIsEmpty()){
            addIpodToCart();
            assertAddedToCart();
            deleteItemFromCart();
            assertCartIsEmpty();
        }
        else {
            System.out.println("Cart is not empty!");
        }
    }

    private boolean assertCartIsEmpty(){
        WebElement cartEmpty = wait.until(ExpectedConditions.elementToBeClickable(By.className("ajax_cart_no_product")));
        assertTrue(cartEmpty.isDisplayed(), "Cart is not empty");
        System.out.println("\nCart is empty");
        return true;
    }

    private void assertAddedToCart(){
        WebElement cartAdded = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart .ajax_cart_quantity")));
        assertThat(cartAdded.getText()).as("Amount in cart").isEqualTo("1");
        System.out.println("\nThe following amount is added to the cart:" + " " + cartAdded.getText());
    }

    private void addIpodToCart() {
        driver.findElement(By.cssSelector("[title=\"More about ipod\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space(text())='iPod shuffle']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_to_cart"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(@title)='Continue shopping']"))).click();
    }

    private void deleteItemFromCart() {
        driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
        List<WebElement> trashIcons = driver.findElements(By.cssSelector(".icon-trash"));

        if (trashIcons.getFirst().isDisplayed()) {
            trashIcons.getFirst().click();
            System.out.println("\nItem has been deleted.");
        } else {
            System.out.println("\nTrash icon not found or not visible.");
        }
    }
}
