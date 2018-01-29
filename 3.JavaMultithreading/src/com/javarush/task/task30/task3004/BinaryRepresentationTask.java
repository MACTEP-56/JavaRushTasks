package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

/**
 * Created by pbunegin on 07.11.2017.
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        BinaryRepresentationTask task = new BinaryRepresentationTask(b);
        task.fork();
        if (b > 0) {
            return  task.join() + result;
        }
        return result;
    }
}
