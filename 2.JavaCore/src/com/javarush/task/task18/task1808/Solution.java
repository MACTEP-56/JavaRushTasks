package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(rd.readLine());
        FileOutputStream file2 = new FileOutputStream(rd.readLine());
        FileOutputStream file3 = new FileOutputStream(rd.readLine());
        byte[] buf = new byte[file1.available()];
        int count = file1.read(buf);
        file2.write(buf, 0, count/2);
        file3.write(buf, count/2, count%2==0?count/2:count/2+1);
        rd.close();
        file1.close();
        file2.close();
        file3.close();
    }
}
