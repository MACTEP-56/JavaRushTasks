package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush — лучший сервис"));
    }

    public static String getPartOfString(String string) {
        int start = 0, end = 0;
        try {
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    start = string.indexOf(" ") + 1;
                    end = string.indexOf(" ") + 1;
                } else
                    end = string.indexOf(" ", end + 1);
                if (end == -1 || start == -1)
                    throw new TooShortStringException(new Exception());
            }
            if (string.indexOf(" ", end + 1) != -1)
                end = string.indexOf(" ", end + 1);
            else end = string.length();


            string = end == string.length() ? string.substring(start) : string.substring(start, end);
        } catch (Exception e) {
            throw new TooShortStringException(e);
        }

        return string;
    }

    public static class TooShortStringException extends RuntimeException {
        public TooShortStringException(Throwable e) {
            super(e);
        }
    }
}
