package com.tatacliq.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {
    static Properties properties;

    public static void initializeConfigReader(){
        properties = new Properties();

        try {
            properties.load(new FileInputStream("src/test/resources/configuration/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getConfigValues(String key){
        return properties.getProperty(key);
    }

    public static void setConfigValue(String key, String value) {
        properties.setProperty(key, value);
    }

    public static byte[] attachScreenShot(WebDriver driver){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }

    public static void setObject(String key ,Object obj){
        properties.put(key, obj);
    }

    public static Object getObject(String key){
       return properties.get(key);
    }
}
