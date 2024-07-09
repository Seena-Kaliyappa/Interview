package com.seena.threads.concurrency;

public class LockMain {
    public static void main(String[] args) {
        LockExample lockExample = new LockExample();
        Thread t1 = new Thread(()-> lockExample.print());
        Thread t2 = new Thread(()-> lockExample.print());
        Thread t3 = new Thread(()-> lockExample.print());
        Thread t4 = new Thread(()-> lockExample.print());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
