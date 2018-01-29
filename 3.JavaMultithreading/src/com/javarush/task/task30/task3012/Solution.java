package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 9, 27, 81, 243, 729, 2187, -1, -3, -9, -27, -81, -243, -729, -2187));
        List<Integer> temp = new ArrayList<>(list);
        while (true) {
            if (temp.isEmpty()) {
                temp = new ArrayList<>(list);
                Collections.shuffle(temp);
            }
            int sum = 0;
            for (int i = 0; i < temp.size(); i++) {
                sum += temp.get(i);
            }
            if (sum != number) {
                temp.remove(0);
                continue;
            } else {
                for (int i = 0; i < temp.size(); i++) {
                    for (int j = i + 1; j < temp.size(); j++) {
                        if (Math.abs(temp.get(i)) == Math.abs(temp.get(j))) {
                            temp.remove(j);
                            temp.remove(i);
                            i--;
                            break;
                        }
                    }
                }
                Collections.sort(temp, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return Math.abs(o1) - Math.abs(o2);
                    }
                });
                System.out.print(number + " = ");
                for (int i = 0; i < temp.size(); i++) {
                    if (temp.get(i) < 0)
                        System.out.print(" " + "-" + " " + Math.abs(temp.get(i)));
                    if (temp.get(i) > 0)
                        System.out.print(" " + "+" + " " + temp.get(i));
                }
                break;
            }
        }
    }
}