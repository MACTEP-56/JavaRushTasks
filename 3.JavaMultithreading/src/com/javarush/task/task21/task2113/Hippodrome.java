package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PBunegin on 23.05.2017.
 */
public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        game.getHorses().add(new Horse("Маня",3,0));
        game.getHorses().add(new Horse("Ваня",3,0));
        game.getHorses().add(new Horse("Даня",3,0));
        game.run();
        game.printWinner();
    }

    public Hippodrome() {
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move() {
        for (Horse x: getHorses())
            x.move();
    }
    public void print() {
        for (Horse x: getHorses())
            x.print();
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner() {
        int winHorse = 0;
        for (int i = 0; i < getHorses().size()-1; i++) {
            if (getHorses().get(i).getDistance() > getHorses().get(i+1).getDistance())
                winHorse = i;
            else
                winHorse = i+1;
        }
        return getHorses().get(winHorse);
    }
    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
