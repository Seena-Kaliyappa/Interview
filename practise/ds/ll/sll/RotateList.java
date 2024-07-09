package com.seena.practise.ds.ll.sll;

public class RotateList {
    Node head = null;
    static class Node{
        int val;
        Node next ;
        Node(int data){
            this.val = data;
            next=null;
        }
    }

    public static Node addAtTail(Node head, int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
        }else{
            Node curr = head;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=node;
        }
        return head;
    }

    public static void printList(Node head ){
        Node curr = head;
        while(curr!=null){
            System.out.print(" "+curr.val);
            curr=curr.next;
        }
        System.out.println();
    }

    public static void main(String args[]){
        Node node = null;
        node = addAtTail(node,2);
        node=  addAtTail(node,4);
        node = addAtTail(node,6);
        node = addAtTail(node,8);
        printList(node);
        Node rotate = rotateList(node, 7);
        printList(rotate);

    }

    private static Node rotateList(Node head, int k) {
        /*
        1.find the length to find the steps
        2. make circle
        3. move the steps
        4. break the circle
        5. return the new head
         */
        int len = 0;
        Node curr = head;
        Node tail = null;
        while(curr != null){
            len ++;
            tail = curr;
            curr = curr.next;
        }
        //making circle
        tail.next = head;
        int step = len-Math.min(k, k%len);
        while(step> 0){
            step--;
            tail = head;
            head = head.next;
        }
        tail.next = null;
        return head;
    }
}
