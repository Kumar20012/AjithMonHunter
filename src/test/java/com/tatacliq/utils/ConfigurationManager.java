package com.tatacliq.utils;

import java.io.FileInputStream;
import java.io.IOException;
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
}
