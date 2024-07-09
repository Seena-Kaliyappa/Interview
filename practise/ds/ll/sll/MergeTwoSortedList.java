package com.seena.practise.ds.ll.sll;

public class MergeTwoSortedList {
    Node head = null;
    int length = 0;
    static class Node{
        int data;
        Node next ;
        Node(int val){
            data = val;
            next = null;
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
            System.out.print(" "+curr.data);
            curr=curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node one = null;
        one = addAtTail(one,1);
        one = addAtTail(one,3);
        one = addAtTail(one,5);

        Node two = null;
        two = addAtTail(two,2);
        two=  addAtTail(two,4);
        two = addAtTail(two,6);
        two = addAtTail(two,8);
        printList(two);
        printList(one);


        Node sum =  mergeLinkedList(one, two);
        printList(sum );
    }

    private static Node mergeLinkedList(Node one, Node two) {
        Node dummy = new Node(-1);
        Node ptr = dummy;
        while(one!=null || two!=null){
            if(one!=null && two!=null){
                if(one.data < two.data){
                    ptr.next = one;
                    one = one.next;
                }else{
                    ptr.next = two;
                    two = two.next;
               }
            }else if( one!=null && two==null){
                ptr.next = one;
                one = one.next;
            }else if (one==null && two!=null){
                ptr.next = two;
                two = two.next;
            }
            ptr = ptr.next;
        }

        return dummy.next;
    }

}
