package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        Path directory = Paths.get(rd.readLine());

        if (Files.isDirectory(directory)) {

            MyFileVisitor myFileVisitor = new MyFileVisitor();
            Files.walkFileTree(directory, myFileVisitor);

            System.out.printf("Всего папок - %d\n", myFileVisitor.getCountDirs());
            System.out.printf("Всего файлов - %d\n", myFileVisitor.getCountFiles());
            System.out.printf("Общий размер - %d\n", myFileVisitor.getSize());
        } else
            System.out.printf("%s - не папка", directory.toAbsolutePath());
    }

    private static class MyFileVisitor<Path> extends SimpleFileVisitor<Path>{
        int countDirs = -1;
        int countFiles = 0;
        long size = 0;

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if (attrs.isDirectory())
                countDirs++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (attrs.isRegularFile()) {
                countFiles++;
                size += attrs.size();
            }
            return FileVisitResult.CONTINUE;
        }

        public int getCountDirs() {
            return countDirs;
        }

        public int getCountFiles() {
            return countFiles;
        }

        public long getSize() {
            return size;
        }
    }
}
