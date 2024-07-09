package com.seena.threads.concurrency;

public class PrintNumbers {

    public static void main(String[] args) {
        Numbers numbers = new Numbers(20);

        Thread odd = new Thread(() -> numbers.printOddNumbers());

        Thread even = new Thread(() -> numbers.printEvenNumbers());

        odd.start();
        even.start();

    }
}
