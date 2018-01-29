package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long number = Long.valueOf(args[1]);
        String text = args[2];

        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        randomAccessFile.seek(number);
        byte[] buf = new byte[text.length()];
        randomAccessFile.read(buf, 0, text.length());
        String temp = convertByteToString(buf);
        randomAccessFile.seek(randomAccessFile.length());
        randomAccessFile.write(temp.equals(text)?"true".getBytes():"false".getBytes());

    }

    private static String convertByteToString(byte[] b) {
        return new String(b);
    }
}
