package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        InputStream file1 = new FileInputStream(args[0]);
        OutputStream file2 = new FileOutputStream(args[1]);
        byte[] buf = new byte[file1.available()];
        file1.read(buf);
        String s = new String(buf, "UTF-8");
        file2.write(s.getBytes("Windows-1251"));
        file1.close();
        file2.close();
    }
}
