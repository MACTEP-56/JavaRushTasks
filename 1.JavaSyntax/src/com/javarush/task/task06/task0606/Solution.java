package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(rd.readLine());
        while(true) {
            int b = a % 10;
            if(b%2 == 0)
                even++;
            else
                odd++;
            a = a / 10;
            if(a == 0)
                break;
        }
        System.out.println("Even: " + even + " Odd: " + odd);

    }
}
