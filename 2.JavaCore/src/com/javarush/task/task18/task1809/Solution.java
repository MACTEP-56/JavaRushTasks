package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(rd.readLine());
        FileOutputStream file2 = new FileOutputStream(rd.readLine());
        byte[] buf = new byte[file1.available()];
        file1.read(buf);
        for (int i = buf.length-1; i >= 0; i--) {
            file2.write(buf[i]);
        }
    }
}
