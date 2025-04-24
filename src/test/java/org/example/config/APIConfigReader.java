package org.example.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class APIConfigReader {
    static Properties properties = new Properties();
    private static final Logger logger = LogManager.getLogger(APIConfigReader.class);

    public static String getProperty(String propertyName){
        try(FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sreeja_g\\IdeaProjects\\learnpath_tasks\\QEML-5\\Browser_options\\task\\src\\test\\java\\org\\example\\config\\config.properties")){
            properties.load(fileInputStream);

            return properties.getProperty(propertyName);
        }catch(IOException e){
            logger.fatal("Unable to get property.", e);
            return null;
        }
    }
}
