package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(rd.readLine()));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(rd.readLine()));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = file1.readLine();
            if (s == null)
                break;
            String[] str = s.trim().split(" ");
            for (String x: str){
                try {
                    Integer.valueOf(x);
                    list.add(x);
                } catch (Exception e){
                }
            }
        }
        for (String x: list)
            file2.write(x + " ");

        rd.close();
        file1.close();
        file2.close();
    }
}
