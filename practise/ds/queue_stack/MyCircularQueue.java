package com.seena.practise.ds.queue_stack;

public class MyCircularQueue {
    int[] queue;
    int front;
    int rear;
    int size;

    public MyCircularQueue(int k) {
    front = 0;
    rear = -1;
    size =0;
    queue = new int[k];
    }

    public boolean enQueue(int value) {
    if(isFull()){
        return false;
    }
    rear = (rear+1)%queue.length;
    queue[rear] = value;
    size++;
    return true;
    }

    public boolean deQueue() {
    if(isEmpty()){
        return false;
    }
    front = (front+1)%queue.length;
    return true;
    }

    public int Front() {
    if(isEmpty()){
        return -1;
    }
    return queue[front];
    }

    public int Rear() {
    if(isEmpty()){
        return -1;
        }
    return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
       return size == queue.length;
    }

    public static void main(String[] args){
         MyCircularQueue obj = new MyCircularQueue(10);
         boolean param_1 = obj.enQueue(5);
         boolean param_2 = obj.deQueue();
         int param_3 = obj.Front();
         int param_4 = obj.Rear();
         boolean param_5 = obj.isEmpty();
         boolean param_6 = obj.isFull();
    }
}
