package com.seena.practise.ds.ll.dll;

public class MyDoublyLinkedList {
    ListNode head = null;
    int length = 0;
    static class ListNode{
        int val;
        ListNode prev, next;
        ListNode(int data ){
            val = data;
            prev = null;
            next = null;
        }
    }

    public void prepend(int data){
        ListNode node = new ListNode(data);
        if(head == null){
            head = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        length++;
    }

    public void append(int data) {
        ListNode node = new ListNode(data);
        if(head == null){
            head = node;
        }else{
            ListNode curr = head;
            while (curr.next!=null){
                curr = curr.next;
            }
            curr.next = node;
            node.prev = curr;
        }
        length++;
    }

    public void addAtIndex(int index, int data){
        if(index<0 || index > length){
            return;
        }
        ListNode node = new ListNode(data);
        if(index == 0){
            prepend(data);
        }else if(index == length){
            append(data);
        }else{
            ListNode curr = head;
            int i =1;
            while(i<index){
                curr = curr.next;
                i++;
            }
            node.next = curr.next;
            curr.next= node;
            node.prev = curr;
        }
        length++;
    }

    public void printList(){
        if(head == null ){
            System.out.println(" List in empty..");
            return;
        }
        ListNode curr = head;
        while(curr!=null){
            System.out.print(" "+curr.val);
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        MyDoublyLinkedList dlist = new MyDoublyLinkedList();
        dlist.prepend(1);
        dlist.prepend(0);
        dlist.printList();
        dlist.append(2);
        dlist.append(4);
        dlist.printList();
        dlist.addAtIndex(3,3);
        dlist.printList();
    }
    }
