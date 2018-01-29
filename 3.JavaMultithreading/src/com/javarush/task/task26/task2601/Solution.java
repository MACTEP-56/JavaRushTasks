package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        Integer[] mas = {13, 8, 15, 5, 17, 4};
//        sort(mas);
//        System.out.println(Arrays.toString(mas));
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        int median = array.length % 2 == 0 ? (array[array.length / 2 - 1] + array[array.length / 2]) / 2 : array[array.length / 2];
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - median) - Math.abs(o2 - median);
            }
        };
        Arrays.sort(array, comp);
        return array;
    }
}
