package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(rd.readLine());
        }
        int min = 0;
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(min).length() > list.get(i).length())
                min = i;
            if (list.get(max).length() < list.get(i).length())
                max = i;
        }

        if(min < max)
            System.out.println(list.get(min));
        else
            System.out.println(list.get(max));
    }
}
