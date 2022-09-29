package utilities;

import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    public static String getProperty(String key){

        return properties.getProperty(key);
    }

}
