package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final  Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\kumar\\Desktop\\mypull code\\Writeown\\src\\test\\java\\resources\\config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load property file" + e);
        }
    }
    public int getWaitTime( String  key){
        return Integer.parseInt(properties.getProperty(key));
    }
    public String getScreenShotPathProperty(String key){
        return properties.getProperty(key);
    }
    public String getBaseUrl(String key){
        return properties.getProperty(key);
    }



}
