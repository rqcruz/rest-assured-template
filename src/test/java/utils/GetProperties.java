package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {
    private static Properties properties;

    public static String getValue(String propertyFilePath, String value){
        try {
            if(properties==null){
                GetProperties.properties = new Properties();
                GetProperties.properties.load(new FileInputStream(propertyFilePath));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return GetProperties.properties.getProperty(value);
    }
}
