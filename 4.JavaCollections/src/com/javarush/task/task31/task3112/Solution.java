package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://www.amigo.com/ship/secretPassword.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        InputStream inputStream = new URL(urlString).openStream();
        Path tempPath = Files.createTempFile("temp-",".tmp");
        Files.copy(inputStream,tempPath);
        Path downloadTempFile = Paths.get(downloadDirectory.toString()+"/"+Paths.get(urlString).getFileName().toString());
        Files.move(tempPath,downloadTempFile);
        return downloadTempFile;
    }
}
