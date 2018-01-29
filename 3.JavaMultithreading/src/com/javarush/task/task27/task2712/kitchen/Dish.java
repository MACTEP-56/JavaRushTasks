package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by PBunegin on 26.10.2017.
 */
public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);
    private int duration;


    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        if (Dish.values().length == 0)
            return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (Dish dish: Dish.values()) {
            stringBuilder.append(dish.name());
            if (Dish.values().length - 1 != dish.ordinal()) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }
}
