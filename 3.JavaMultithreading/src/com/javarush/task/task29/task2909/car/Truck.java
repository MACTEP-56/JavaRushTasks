package com.javarush.task.task29.task2909.car;

/**
 * Created by PBunegin on 02.08.2017.
 */
public class Truck extends Car {
    public Truck(int type, int numberOfPassengers) {
        super(type, numberOfPassengers);
    }

    public Truck(int numberOfPassengers) {
        super(0, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }
}
