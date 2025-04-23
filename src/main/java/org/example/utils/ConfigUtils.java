package org.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
    private static Properties properties;

    static {
        try {
            FileInputStream file = new FileInputStream("config.properties");
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}