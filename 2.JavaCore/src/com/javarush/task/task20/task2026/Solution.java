package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 1) {
                    int x1 = i;
                    int y1 = j;
                    while (i < a.length) {
                        if (a[i][j] == 0) break;
                        i++;
                    }
                    i--;
                    while (j < a.length) {
                        if (a[i][j] == 0) break;
                        j++;
                    }
                    j--;
                    for (int l = x1; l <= i; l++)
                        for (int k = y1; k <= j; k++)
                            a[l][k] = 0;
                    count++;
                }
            }
        return count;
    }
}
