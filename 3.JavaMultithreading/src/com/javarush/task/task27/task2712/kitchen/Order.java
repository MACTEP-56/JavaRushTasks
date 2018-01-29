package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by PBunegin on 26.10.2017.
 */
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
        ConsoleHelper.writeMessage(this.toString());
    }

    public int getTotalCookingTime() {
        int res = 0;
        for (Dish dish: dishes) {
            res += dish.getDuration();
        }
        return res;
    }

    @Override
    public String toString() {
        if (dishes == null)
            return "";
        return "Your order: "
                + dishes
                + " of "
                + tablet;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }
}
