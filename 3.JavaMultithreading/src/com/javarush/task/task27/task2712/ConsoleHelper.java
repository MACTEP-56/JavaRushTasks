package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PBunegin on 26.10.2017.
 */
public class ConsoleHelper {

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        return rd.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishResult = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите название блюда :");
        String str;
        while (!(str = readString()).equalsIgnoreCase("exit")) {
            boolean isDish = false;
            for (Dish dish: Dish.values()) {
                if (dish.toString().equalsIgnoreCase(str)) {
                    isDish = dishResult.add(dish);
                    break;
                }
            }
            if (!isDish)
                writeMessage("Такого блюда нет");
        }
        return dishResult;
    }
}
