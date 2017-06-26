package com.nhry.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @version V1.0
 * @FileName: PropertitesUtil.java
 * @Description: TODO
 * @author: chenbaizhong
 */
public class PIPropertitesUtil {
    private static Properties properties = new Properties();

    static {
        try {
            java.io.File file = ResourceUtils.getFile("classpath:pi.properties");
            InputStream inputFile = new FileInputStream(file);
            properties.load(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        try {
            return properties.get(key).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public static void main(String[] args) {
        System.out.println("ddddd" + getValue("PI.CRM.EXEC"));
    }
}
