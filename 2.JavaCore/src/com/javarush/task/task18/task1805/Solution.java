package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(rd.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (inputStream.available() > 0)
            list.add(inputStream.read());
        inputStream.close();
        Collections.sort(list);
        for (int i = 0; i < list.size()-1;) {
            if (list.get(i) == list.get(i+1))
                list.remove(i);
            else
                i++;
        }
        for (Integer x: list)
            System.out.print(Character.getNumericValue(x));
    }
}
