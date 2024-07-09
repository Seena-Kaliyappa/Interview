package com.seena.threads.concurrency;

public class Chat {
    private boolean isQuestion = true;
    private int counter = 0;
    private int number;

    public Chat(int number) {
        this.number = number;
    }

    public synchronized  void isQuestion() {
        while (counter < number) {
            if(!isQuestion) {
                try {
                    wait();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            System.out.println("Question");
            counter++;
            isQuestion = false;
            notify();
        }
    }

    public synchronized  void isAnswer() {
        while (counter < number) {
            if(isQuestion) {
                try {
                    wait();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            System.out.println("Answer");
            counter++;
            isQuestion = true;
            notify();
        }
    }
}
