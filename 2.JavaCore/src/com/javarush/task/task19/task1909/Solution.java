package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(rd.readLine()));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(rd.readLine()));
        while (file1.ready()) {
            String s = file1.readLine().replaceAll("\\.", "!");
            file2.write(s + "\r\n");
        }
        rd.close();
        file1.close();
        file2.close();
    }
}
