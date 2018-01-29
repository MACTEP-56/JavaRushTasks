package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        for (String x : getTokens("level22.lesson13.task01", "."))
            System.out.println(x);

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer stok = new StringTokenizer(query,delimiter);
        String[] res = new String[stok.countTokens()];
        int i = 0;
        while (stok.hasMoreTokens()) {
            res[i] = stok.nextToken();
            i++;
        }
        return res;
    }
}
