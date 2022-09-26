package com.company.logic;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Settings {
    static private final String PRODUCTION_PATH = "../src/main/resources/application-production.properties";
    static private final String DEV_PATH = "../src/main/resources/application-dev.properties";
    private static String path;

    public static Properties getSettings(String profile) {
        if (profile.equals("production")) {
            path = PRODUCTION_PATH;
        } else if (profile.equals("dev")) {
            path = DEV_PATH;
        } else {
            System.err.println("Wrong profile");
            System.exit(-1);
        }
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (properties);
    }
}
