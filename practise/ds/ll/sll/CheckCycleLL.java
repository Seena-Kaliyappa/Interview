package com.seena.practise.ds.ll.sll;

public class CheckCycleLL {

    Node head = null;
    int length = 0;
    static class Node{
        int data;
        Node next;
        Node(int val){
            data= val;
            next= null;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if(head == null){
            head = node;
            length++;
        }else{
            Node last = head;
            while(last.next!=null){
                last = last.next;
            }
            last.next = node;
            length++;
        }

    }
    public boolean checkCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slowPtr = head;
        Node fastPtr = head.next;
        while (slowPtr != fastPtr) {
            if (fastPtr == null || fastPtr.next == null) {
                return false;
            }
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return true;
    }

    public boolean hasCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // Starting of loop
    /*
        If loop is started, then slow and fast will meet at some point of circle. To find the start of loop,
        We need to initialize low to head and fast in same position. If we move both low and fast, then they will meet at startin point of loop
     */

    public Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        boolean isLoop = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isLoop = true;
                break;
            }
        }
        // loop is detected, initialize low = head
        if(isLoop){
            slow = head;
            while(slow!=fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;

    }


    public static void main(String args[]){
        CheckCycleLL ll = new CheckCycleLL();
        ll.checkCycle(ll.head);
    }
}
