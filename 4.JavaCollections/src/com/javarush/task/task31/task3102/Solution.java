package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<File> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        queue.add(new File(root));
        File temp;
        while((temp = queue.poll()) != null) {
            if (temp.isDirectory()) {
                for (File file: temp.listFiles())
                    queue.add(file);
            }
            else
                result.add(temp.getAbsolutePath());
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        for (String listFile: getFileTree("D:\\1")) {
            System.out.println(listFile);
        }
    }
}
