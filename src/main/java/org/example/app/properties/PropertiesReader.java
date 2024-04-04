package org.example.app.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public static Properties properties;
    private static String propPath = "src/test/resources/application.properties";

    public static void initializePropertyFile(){
        properties = new Properties();
        try {
            InputStream input = new FileInputStream(propPath);
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}