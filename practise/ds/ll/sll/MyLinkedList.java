package com.seena.practise.ds.ll.sll;

public class MyLinkedList {
    Node head = null;
    int length =0;
    static class Node {
        int val;
        Node next;
        Node(int value){
            this.val =value;
            next = null;
        }
    }
        /** Initialize your data structure here. */
    public MyLinkedList() {
             // return 3
    }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            int val =-1;
            Node cur = head;
            int i =0;
            while(i<length){
                if(i == index){
                    val = cur.val;
                    break;
                }
                cur = cur.next;
                i++;
            }
        return val;
    }


    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node node = new Node(val);
            if(head == null){
                head = node;
                length++;
            }else{
                node.next=head;
                head = node;
                length++;
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

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index ==0 ){
                addAtHead(val);
                return;
            }
            if(index == length){
                addAtTail(val);
                return;
            }
            int i =0;
            Node pre = head;
            while(i<index-1){
                pre = pre.next;
                i++;
            }
            Node node = new Node(val);
            node.next = pre.next;
            pre.next = node;
            length++;

    }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index>=length){
                return;
            }
            if(length == 0 || length == 1){
                head = null;
                return;
            }
            if(length ==2 ){
                head.next = null;
                return;
            }

            if(index == 0){
                head = head.next;
                length--;
                return;
            }
            Node pre =head;
            Node target = pre.next.next;
            for(int i=0; i<index-1;i++){
                pre = pre.next;
                target = pre.next.next;
            }
            pre.next = target;
            length--;

    }

    public void printList(){
            if(head == null){
                System.out.println(" List is Empty ");
            }
            Node node = head;
            while(node != null){
                System.out.print( " "+ node.val);
                node = node.next;
            }
            System.out.println();
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

    public static void main(String[] args){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.printList();
        myLinkedList.addAtTail(3);
        myLinkedList.printList();
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        myLinkedList.printList();
        System.out.println(myLinkedList.get(1));
        myLinkedList.printList();
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        myLinkedList.printList();
        System.out.println(myLinkedList.get(1));
        myLinkedList.printList();
    }
}
