package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String fileName = null;
        try(BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = rd.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(fileName))) {
            while (rd.ready()) {
                Collections.addAll(list, rd.readLine().split("[^\\w]"));
            }
            System.out.println(Collections.frequency(list, "world"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
