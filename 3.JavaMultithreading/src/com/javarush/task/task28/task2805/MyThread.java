package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by PBunegin on 10.10.2017.
 */
public class MyThread extends Thread {
    private static AtomicInteger priority = new AtomicInteger(1);

    public MyThread(ThreadGroup group, String s) {
        super(group, s);
        if (group.getMaxPriority() < priority.get()) {
            this.setPriority(group.getMaxPriority());
            priority.incrementAndGet();
            if (priority.get() > 10)
                priority.set(1);
        } else if (priority.get() > 10) {
            priority.set(1);
            this.setPriority(priority.getAndIncrement());
        } else
            this.setPriority(priority.getAndIncrement());
    }

    public MyThread() {
        super();
        if (priority.get() > 10) {
            priority.set(1);
            this.setPriority(priority.getAndIncrement());
        } else
            this.setPriority(priority.getAndIncrement());
    }

    public MyThread(Runnable target) {
        super(target);
        if (priority.get() > 10) {
            priority.set(1);
            this.setPriority(priority.getAndIncrement());
        } else
            this.setPriority(priority.getAndIncrement());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (group.getMaxPriority() < priority.get()) {
            this.setPriority(group.getMaxPriority());
            priority.incrementAndGet();
            if (priority.get() > 10)
                priority.set(1);
        } else if (priority.get() > 10) {
            priority.set(1);
            this.setPriority(priority.getAndIncrement());
        } else
            this.setPriority(priority.getAndIncrement());
    }

    public MyThread(String name) {
        super(name);
        if (priority.get() > 10) {
            priority.set(1);
            this.setPriority(priority.getAndIncrement());
        } else
            this.setPriority(priority.getAndIncrement());
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if (priority.get() > 10) {
            priority.set(1);
            this.setPriority(priority.getAndIncrement());
        } else
            this.setPriority(priority.getAndIncrement());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (group.getMaxPriority() < priority.get()) {
            this.setPriority(group.getMaxPriority());
            priority.incrementAndGet();
            if (priority.get() > 10)
                priority.set(1);
        } else if (priority.get() > 10) {
            priority.set(1);
            this.setPriority(priority.getAndIncrement());
        } else
            this.setPriority(priority.getAndIncrement());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (group.getMaxPriority() < priority.get()) {
            this.setPriority(group.getMaxPriority());
            priority.incrementAndGet();
            if (priority.get() > 10)
                priority.set(1);
        } else if (priority.get() > 10) {
            priority.set(1);
            this.setPriority(priority.getAndIncrement());
        } else
            this.setPriority(priority.getAndIncrement());
    }
}
