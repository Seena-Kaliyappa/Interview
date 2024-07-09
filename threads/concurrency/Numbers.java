package com.seena.threads.concurrency;

public class Numbers {
    private int number;
    private int counter = 0;
    public Numbers(int n) {
        this.number = n;
    }

    public synchronized  void printOddNumbers() {
        while (counter < number) {
            if(counter % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            System.out.println(counter);
            counter++;
            notify();
        }
    }

    public synchronized  void printEvenNumbers() {
        while (counter < number) {
            if(counter % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            System.out.println(counter);
            counter++;
            notify();
        }
    }
}
