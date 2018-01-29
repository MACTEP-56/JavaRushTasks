package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        byte[] etalon = "zxcvbnmlkjhgfdsaqwertyuiopZXCVBNMLKJHGFDSAQWERTYUIOP0123456789".getBytes();
        byte[] buf = new byte[8];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = true;
        while (true) {
            for (int i = 0; i < buf.length; i++) {
                buf[i] = etalon[new Random().nextInt(etalon.length)];
            }
            for (byte bt : buf) {
                if (!((bt > 47 && bt < 58) || (bt > 64 && bt < 91) || (bt > 96 && bt < 123))) {
                    d = false;
                    break;
                }
                if (bt > 47 && bt < 58)
                    a = true;
                if (bt > 64 && bt < 91)
                    b = true;
                if (bt > 96 && bt < 123)
                    c = true;
            }
            if (a && b && c && d) {
                try {
                    byteArrayOutputStream.write(buf);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return byteArrayOutputStream;
    }
}