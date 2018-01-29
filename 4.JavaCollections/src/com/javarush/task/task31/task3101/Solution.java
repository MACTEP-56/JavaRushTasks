package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        List<File> fileList = getList(path);

        if (!fileList.isEmpty()) {
            Collections.sort(fileList, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            if (FileUtils.isExist(resultFileAbsolutePath))
                FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

            try (FileOutputStream fileOutput = new FileOutputStream(allFilesContent, true)) {
                for (File file : fileList) {
                    FileInputStream fileInput = new FileInputStream(file);
                    while (fileInput.available() > 0) {
                        byte[] buf = new byte[1000];
                        int len = fileInput.read(buf);
                        fileOutput.write(buf, 0, len);
                    }
                    fileOutput.write("\n".getBytes());
                    fileInput.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static List<File> getList(File path) {
        List<File> result = new ArrayList<>();
        for (File file : path.listFiles()) {
            if (file.isDirectory()) {
                result.addAll(getList(file));
                continue;
            }
            if (file.length() > 50)
                FileUtils.deleteFile(file);
            else
                result.add(file);
        }
        return result;
    }
}
