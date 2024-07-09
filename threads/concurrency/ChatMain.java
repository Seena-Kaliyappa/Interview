package com.seena.threads.concurrency;

public class ChatMain {

    public static void main(String[] args) {

        Chat chat = new Chat(20);
        Thread q = new Thread(() -> chat.isQuestion());
        Thread a = new Thread(() -> chat.isAnswer());

        q.start();
        a.start();
    }
}
