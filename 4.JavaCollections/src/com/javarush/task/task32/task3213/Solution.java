package com.javarush.task.task32.task3213;

import java.io.*;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter stringWriter = new StringWriter();
        try {
            int c;
            while ((c = reader.read()) != -1) {
                stringWriter.write((char)(c + key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

}
