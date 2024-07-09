package com.seena.threads;

import java.util.concurrent.CountDownLatch;

public class Service implements Runnable{
    String serviceName ;
    CountDownLatch latch;
    public Service(String name, CountDownLatch latch){
        this.serviceName = name;
        this.latch = latch;
    }
    @Override
    public void run() {
        try{
            Thread.sleep(1000);

        }catch (InterruptedException ex){

        }
       System.out.println(serviceName + " Started...");
       latch.countDown();
    }
}
