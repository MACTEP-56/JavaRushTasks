package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileName);
        load(inputStream);
        save(outputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println(properties != null);
        if (properties != null) {
            for (Map.Entry<String, String> entry: properties.entrySet()){
                printStream.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
        if (Boolean.valueOf(rd.readLine())) {
            while (rd.ready()) {
                String[] str = rd.readLine().split(" = ");
                properties.put(str[0], str[1]);
            }
        }
    }

    public static void main(String[] args) {

    }
}
