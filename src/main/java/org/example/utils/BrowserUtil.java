package org.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BrowserUtil {
    public static String getBrowserFromSystemOrFile() {
        String browser = System.getProperty("browser");
        System.out.println("Browser: "+browser);
        if (browser != null && !browser.isEmpty()) {
            System.out.println("🔧 Browser from system property: " + browser);
            return browser;
        }

        try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            browser = prop.getProperty("browser");
            System.out.println("📁 Browser from config file: " + browser);
        } catch (IOException ex) {
            throw new RuntimeException("❌ Failed to load browser from config file", ex);
        }

        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("❌ No browser provided in CLI or config file");
        }

        return browser;
    }
}
