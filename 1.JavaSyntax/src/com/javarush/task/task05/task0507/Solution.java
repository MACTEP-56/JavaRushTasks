package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int sum = 0;
        double sa = 0;
        while(true){
            int a = Integer.parseInt(rd.readLine());
            if(a == -1){
                sa = (double) sum / count;
                break;
            }
            else {
                count++;
                sum = sum + a;
            }
        }
        System.out.println(sa);
    }
}

