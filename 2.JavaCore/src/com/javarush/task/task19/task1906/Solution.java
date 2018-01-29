package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        rd.close();
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        int count = 0;
        while (fileReader.ready()) {
            int s = fileReader.read();
            if (++count%2 == 0)
                fileWriter.write(s);
        }
        fileReader.close();
        fileWriter.close();
    }
}
