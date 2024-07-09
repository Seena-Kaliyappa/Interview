package com.seena.threads.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private final Lock queueLock = new ReentrantLock();

    public void print() {
        queueLock.lock();
        System.out.println(Thread.currentThread().getName() +" printing..");
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +" Wait Completed..");
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }finally {
            queueLock.unlock();
        }
    }
}
