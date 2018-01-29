package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(rd.readLine());
        rd.close();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();

        while (inputStream.available() > 0){
            list.add(inputStream.read());
        }
        inputStream.close();

        int minCount = list.size();
        for (int i = 0; i < list.size();) {
            int count = 1;
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    count++;
                    list.remove(j);
                    j--;
                }
            }
            if (minCount > count){
                minCount = count;
                res.clear();
                res.add(list.get(i));
            } else if (minCount == count){
                res.add(list.get(i));
            }
            list.remove(i);
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
