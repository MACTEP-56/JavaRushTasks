package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        FileReader fileReader = new FileReader(new File(fileName));
        T object = mapper.readValue(fileReader, clazz);
        return object;
    }

    public static void main(String[] args) {

    }
}
