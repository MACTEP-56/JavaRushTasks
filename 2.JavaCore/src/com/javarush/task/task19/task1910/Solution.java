package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(rd.readLine()));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(rd.readLine()));

        while (file1.ready()) {
            String str = file1.readLine().replaceAll("[\\p{P}]]", "");
        }
    }
}
