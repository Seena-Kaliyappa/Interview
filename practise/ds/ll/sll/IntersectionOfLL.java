package com.seena.practise.ds.ll.sll;

public class IntersectionOfLL {
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

    public void addAtTail(Node node){
        if(head == null){
            head = node;
        }else{
            Node curr = head;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=node;
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

    // a+b+c
    //c+b+a
    // a+b+c == c+b+a in count..
    public Node checkIntersection(Node head1, Node head2){
        Node a = head1;
        Node b = head2;
        while(a!=b){
            a = a==null?head2:a.next;
            b = b==null?head1:b.next;
        }
        return a;
    }
    public static Node createNode(int val){
        return new Node(val);
    }


    public static void main(String[] args){
        IntersectionOfLL list1 = new IntersectionOfLL();
        IntersectionOfLL list2 = new IntersectionOfLL();

        list1.addAtTail(createNode(4));
        list1.addAtTail(createNode(1));
        list1.addAtTail(createNode(8));
        list1.addAtTail(createNode(4));
        list1.addAtTail(createNode(5));
        list1.printList();

        list2.addAtTail(createNode(5));
        list2.addAtTail(createNode(6));
        list2.addAtTail(createNode(1));
        list2.addAtTail(createNode(8));
        list2.addAtTail(createNode(4));
        list2.addAtTail(createNode(5));
        list2.printList();
        System.out.println(" Intersection Node "+list1.checkIntersection(list1.head,list2.head));
    }
}
