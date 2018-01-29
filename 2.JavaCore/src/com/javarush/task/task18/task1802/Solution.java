package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inp = new FileInputStream(rd.readLine());
        int max = 0;
        while (inp.available() > 0){
            int temp = inp.read();
            if (max > temp)
                max = temp;
        }
        System.out.println(max);
    }
}
