package org.example.utils;

import org.example.drivers.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waitility {
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    // Optional: wait for list of elements
    public static List<WebElement> waitForElements(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), DEFAULT_TIMEOUT);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public static WebElement waitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), DEFAULT_TIMEOUT);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForPageLoaded() {
        new WebDriverWait(DriverFactory.getDriver(), DEFAULT_TIMEOUT).until(
                driver -> ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState").equals("complete")
        );
    }
}
