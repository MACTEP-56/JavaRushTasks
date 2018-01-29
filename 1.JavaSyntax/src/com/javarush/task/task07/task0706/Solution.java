package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int sum1 = 0;
        int sum2 = 0;
        int[] mas = new int[15];
        for (int i = 0; i < mas.length; i++) {
            String s = rd.readLine();
            if(s.isEmpty()){
                System.out.println("Введите число!");
                continue;
            }
            mas[i] = Integer.parseInt(s);
        }
        for (int i = 0; i < mas.length; i++) {
            if(i%2 == 0)
                sum2 += mas[i];
            else
                sum1 += mas[i];
        }
        if (sum1 > sum2)
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        if (sum1 < sum2)
            System.out.println("В домах с четными номерами проживает больше жителей.");
    }
}
