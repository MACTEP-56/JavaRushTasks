package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inp = new FileInputStream(rd.readLine());
        rd.close();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (inp.available() > 0){
            list.add(inp.read());
        }
        inp.close();
        ArrayList<Integer> res = new ArrayList<Integer>();
        int maxCount = 0;
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i) == list.get(j))
                    count++;
            }
            if (maxCount < count){
                maxCount = count;
                res.clear();
                res.add(list.get(i));
            } else if (maxCount ==count){
                res.add(list.get(i));
            }
        }
        for (Integer x: res){
            String.valueOf(x);
        }

    }
}
