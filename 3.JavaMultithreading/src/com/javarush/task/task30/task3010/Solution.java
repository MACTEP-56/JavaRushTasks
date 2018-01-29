package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        try {
            if (args[0].matches("\\p{LD}*")) {
                BigInteger x;
                int k = 0;
                for (int i = 36; i > 1; i--) {
                    try {
                        x = new BigInteger(args[0], i);
                        k = i;
                    } catch (NumberFormatException e) {
                    }
                }
                if (k == 0)
                    System.out.println("incorrect");
                else
                    System.out.println(k);
            } else {
                System.out.println("incorrect");
            }
        } catch (Exception e) {
        }
    }
}