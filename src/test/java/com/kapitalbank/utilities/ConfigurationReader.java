package com.kapitalbank.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    // make it "private" so we are limiting access to the object
    //"static" is to make sure its created and loaded before everything else
    private static Properties properties = new Properties();
    static {
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            //close the file in the memory
            file.close();

        } catch(IOException e){
            System.out.println("File not found with given path!!!");
            e.printStackTrace();
        }

    }

    // create a utility method to use the object to read
    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }



}
