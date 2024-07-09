package com.seena.practise.ds.ll.sll;

import java.util.ArrayList;

public class RotateInSpiralOrder {

    Node head = null;
    static class Node {
        int data;
        Node next;

        Node(int val){
            data= val;
            next= null;
        }
    }

    public void addAtTail(final int val) {
        Node node = new Node(val);

        if (head == null) {
            head = node;
        } else {
            Node curr = head;
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
    }

    public void printList(){
        Node curr = head;
        while(curr!=null){
            System.out.print(" "+curr.data);
            curr=curr.next;
        }
        System.out.println();
    }

    public void printInSpiral() {
        ArrayList<Integer> list = new ArrayList();
        Node curr = head;
        while (curr != null) {
            list.add(curr.data);
            curr = curr.next;
        }
        final int size = list.size();
        final int mid = (size-1)/2;
        int left = mid;
        int right = mid+1;
        while (left >=0 || right <size) {

            if (left >= 0) {
                System.out.print("==>" +list.get(left));
            }
            if(right < size){
                System.out.print("==>" +list.get(right));
            }
            left--;
            right ++;
        }
    }

    public static void main(String[] args) {
        RotateInSpiralOrder list = new RotateInSpiralOrder();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        list.addAtTail(6);
        list.printList();
        list.printInSpiral();
    }
}
