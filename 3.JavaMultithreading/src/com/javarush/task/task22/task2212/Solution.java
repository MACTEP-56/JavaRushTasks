package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        if (telNumber.isEmpty()) return false;

        if (telNumber.matches("^\\+.{12,16}") && telNumber.replaceAll("\\D", "").matches("\\d{12}"))
            if (telNumber.matches("^\\+\\d*(\\(\\d{3}\\))?\\d+-?\\d+-?\\d+"))
                return true;

        if (telNumber.matches("^(\\(|\\d).{9,13}") && telNumber.replaceAll("\\D", "").matches("\\d{10}"))
            if (telNumber.matches("\\d*(\\(\\d{3}\\))?\\d+-?\\d+-?\\d+"))
                return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("(0)501234567"));
    }
}
