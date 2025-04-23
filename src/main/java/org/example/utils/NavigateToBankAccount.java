package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigateToBankAccount {

    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    public static void goToCreateNewBankAccount(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        // Click on the "Entities" dropdown in the navbar
        WebElement entitiesDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("entity-menu") // Adjust this ID if your JHipster app uses a different one
        ));
        entitiesDropdown.click();

        // Click on "Bank Account" link
        WebElement bankAccountLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[routerlink='/bank-account']") // Specific router link
        ));
        bankAccountLink.click();

        // Click the "Create a new Bank Account" button
        WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.create-bank-account") // Adjust selector as needed
        ));
        createButton.click();
    }
}
