package com.seena.practise.ds.ll.sll;

public class SumOfTwoNodes {
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

    public void printList(){
        Node curr = head;
        while(curr!=null){
            System.out.print(" "+curr.data);
            curr=curr.next;
        }
        System.out.println();
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
        one = addAtTail(one,4);
        one = addAtTail(one,5);
        one = addAtTail(one,6);

        Node two = null;
        two = addAtTail(two,4);
        two=  addAtTail(two,5);
        two = addAtTail(two,6);
        two = addAtTail(two,7);
        printList(two);
        printList(one);


        Node sum =  sumOfNodes(one, two);
       printList(sum );
    }

    private static Node sumOfNodes(Node node1, Node node2) {
        int val1=0,val2=0, sum=0, carry=0;
        Node dummy = new Node(-1);
        Node ptr = dummy;

        while(node1!=null || node2!=null){
            if(node1!=null){
                val1 = node1.data;
                node1 = node1.next;
            }else{
                val1=0;
            }
            if(node2 != null){
                val2 = node2.data;
                node2 = node2.next;
            }else{
                val2 = 0;
            }
            sum = val1+val2+carry;
            carry = sum/10;
            sum = sum%10;
            Node tmp = new Node(sum);
            ptr.next = tmp;
            ptr = ptr.next;
        }
        if(carry!=0){
            Node tmp = new Node(carry);
            ptr.next = tmp;
        }

        return dummy.next;
    }


}
