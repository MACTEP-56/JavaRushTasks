package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by PBunegin on 27.10.2017.
 */
public class Cook extends Observable implements Observer{
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable tablet, Object order) {
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + ((Order) order).getTotalCookingTime() + "min");
        setChanged();
        notifyObservers(order);
    }
}
