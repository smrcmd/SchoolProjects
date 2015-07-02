/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 *
 * @author Sophie
 */
public class Presentation {

    int a;
    int b;
    int c;
    int d;
    
    
    public int simpleMath() {
        a = 5;
        b = 7;
        d = a + b;
        return d;
    }

    public Map<String, String> capitalNames() {
        Map<String, String> capitalNames = new TreeMap<String, String>();
        capitalNames.put("Missouri", "Jefferson City");
        capitalNames.put("New York", "Albany");
        capitalNames.put("Florida", "Tallahassee");
        capitalNames.put("Indiana", "Indianapolis");
        capitalNames.put("California", "Sacramento");
        capitalNames.put("Washington", "Olympia");

        return capitalNames;
    }

    public Properties loadProperties() throws FileNotFoundException, IOException {
        Properties properties = new Properties();
        FileInputStream is = new FileInputStream("src/edu/autobots.properties");
        properties.load(is);
        return properties;
    }

    public String sophie() {
        String sophie = null;
        int a = 9;
        if ((5 + 5) == a) {
            sophie = "whatever";
        }
        return sophie;
    }
}
