package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(rd.readLine()));
        }
        int max = 1;
        int count = 1;
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) == list.get(i+1))
                count++;
            else
                count = 1;

            if (max < count)
                max = count;
        }
        System.out.println(max);
    }
}