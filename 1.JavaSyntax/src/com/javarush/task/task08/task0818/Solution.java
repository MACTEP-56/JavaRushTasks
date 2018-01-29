package com.javarush.task.task08.task0818;

import java.util.*;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Petrov", 1000);
        map.put("Petrova", 2000);
        map.put("Petrovi", 200);
        map.put("Sidorov", 2300);
        map.put("Sidorova", 300);
        map.put("Sidorovi", 1000);
        map.put("Ivanov", 1000);
        map.put("Ivanova", 140);
        map.put("Ivanovi", 3000);
        map.put("Shmelev", 5000);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> temp = new HashMap<>(map);
        for (Map.Entry<String, Integer> entry: temp.entrySet()){
            if (entry.getValue() < 500)
                map.remove(entry.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = createMap();
        removeItemFromMap(map);
    }
}