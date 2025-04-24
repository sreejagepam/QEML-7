package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
        // Prevent external instantiation
    }
    public static void chooseDriver(String browser){
        switch (browser.toLowerCase()) {
            case "chrome":
                // Add ChromeOptions if needed
                driver.set(createDriver("chrome"));
                break;
            case "firefox":
                driver.set(createDriver("firefox"));
                break;
            case "edge":
                driver.set(createDriver("edge"));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            throw new IllegalStateException("WebDriver not initialized. Call chooseDriver() first.");// Default to Chrome; parameterize as needed
        }
        return driver.get();
    }

    private static WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                // Add ChromeOptions if needed
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // Crucial to avoid memory leaks
        }
    }
}
