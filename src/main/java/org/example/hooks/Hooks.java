package org.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.DriverManager;
import org.openqa.selenium.WebDriver;

import static org.example.utils.BrowserUtil.getBrowserFromSystemOrFile;


public class Hooks {

    @Before
    public void setUp() {
        String browser = getBrowserFromSystemOrFile();
        System.out.println(">>> [Hooks] System.getProperty(browser): " + browser);
        System.out.println(">>> Browser received from system property: " + browser);
        DriverManager.chooseDriver(browser);
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        System.out.println("Browser started before scenario.");
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
        System.out.println("Browser closed after scenario.");
    }
}
