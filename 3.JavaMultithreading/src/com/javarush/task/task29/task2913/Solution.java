package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        String res = "";
        if (a > b) {
            while (a >= b){
                res += a-- + " ";
            }
            return res.trim();
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            while (a <= b){
                res += a++ + " ";
            }
            return res.trim();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Solution solution = new Solution();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}