package com.seena.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueuePC {
    public static void main(String[] args){
        ArrayBlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(1);
        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);
        new Thread(p).start();
        new Thread(c).start();
    }

    static class Message{
        private final String message;
        public Message(String msg){
            this.message = msg;
        }
        public String getMsg() {
            return message;
        }
    }
    static class Producer implements Runnable{
        BlockingQueue<Message> queue;
        public Producer(BlockingQueue q){
            this.queue = q;
        }
        @Override
        public void run() {
            for(int i = 0; i<100;i++){
                try{
                    Message msg = new Message(""+i);
                    Thread.sleep(100);
                    queue.put(msg);
                    System.out.println(" Produced msg "+i);
                }catch (InterruptedException ex){

                }
            }
            try{
                queue.put(new Message("Exit"));
            }catch (InterruptedException ex){
            }
        }
    }

    static class Consumer implements Runnable{
        BlockingQueue<Message> queue;
        public Consumer(BlockingQueue q){
            this.queue = q;
        }
        @Override
        public void run() {
            try {
                Message msg;
                //consuming messages until exit message is received
                while((msg = queue.take()).getMsg() !="Exit"){
                    Thread.sleep(100);
                    System.out.println("Consumed "+msg.getMsg());
                }
            }catch (InterruptedException ex) {

            }
            }
        }
}
