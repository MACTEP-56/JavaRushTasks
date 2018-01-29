package com.javarush.task.task29.task2909.car;

/**
 * Created by PBunegin on 02.08.2017.
 */
public class Cabriolet extends Car {
    public Cabriolet(int type, int numberOfPassengers) {
        super(type, numberOfPassengers);
    }

    public Cabriolet(int numberOfPassengers) {
        super(2, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }
}
