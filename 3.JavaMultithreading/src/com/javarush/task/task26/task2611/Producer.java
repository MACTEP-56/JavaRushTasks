package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by PBunegin on 05.09.2017.
 */
public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }


    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        int i = 1;
        try {
            while (!currentThread.isInterrupted()) {
                map.put(String.valueOf(i), "Some text for " + i);
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", currentThread.getName()));
        }
    }
}
