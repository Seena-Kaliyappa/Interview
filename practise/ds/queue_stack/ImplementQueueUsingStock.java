package com.seena.practise.ds.queue_stack;

import java.util.Stack;

/**
 *
 */
public class ImplementQueueUsingStock {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public ImplementQueueUsingStock() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            s1.push(x);
        } else {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(x);
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }

    public int pop() {
       return s1.pop();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }
}
