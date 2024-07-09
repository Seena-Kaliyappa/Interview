package com.seena.threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        Thread t1 = new Thread(new Service(" service1", latch));
        t1.start();
        Thread t2 = new Thread(new Service(" service2", latch));
        t2.start();
        Thread t3 = new Thread(new Service(" service3", latch));
        t3.start();
        latch.await();
        System.out.println(" Main Service started...");
    }

}
