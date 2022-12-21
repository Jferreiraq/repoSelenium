/*
package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDriven {
    //Atributo
    public static Properties props;

    public static String getProperty(String key){
        props = new Properties();
        String rutaFile = System.getProperty("user.dir")+"\\src\\test\\resources\\properties.properties";

        try {
            InputStream input = new FileInputStream(rutaFile);

            props.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return props.getProperty(key);
    }
}

 */
