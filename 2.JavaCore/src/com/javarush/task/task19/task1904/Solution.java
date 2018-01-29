package com.javarush.task.task19.task1904;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner scaner) {
            this.fileScanner = scaner;
        }

        @Override
        public Person read() throws IOException {
            BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream("d:\\1.txt")));
            String[] str = rd.readLine().split(" ");
            String lastName = str[0];
            String firstName = str[1];
            String middleName = str[2];
            int day = Integer.valueOf(str[3]);
            int month = Integer.valueOf(str[4]);
            int year = Integer.valueOf(str[5]);


            return new Person("Ivan", "Ivonovich", "Ivanov", new Date(year,month,day));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
