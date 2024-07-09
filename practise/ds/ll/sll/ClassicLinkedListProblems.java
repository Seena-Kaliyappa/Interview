package com.seena.practise.ds.ll.sll;

public class ClassicLinkedListProblems {

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

    public void addAtTail(int val){
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
    }

    public void printList(){
        Node curr = head;
        while(curr!=null){
            System.out.print(" "+curr.data);
            curr=curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        ClassicLinkedListProblems list = new ClassicLinkedListProblems();
        list.addAtTail(4);
        list.addAtTail(1);
        list.addAtTail(8);
        list.addAtTail(4);
        list.addAtTail(4);
        list.addAtTail(5);
        list.addAtTail(4);
        list.printList();
        list.reverseList();
        list.printList();
        list.OddEvenArrange();
        list.printList();
        list.removeNode(4);
        list.printList();
        list.removeNodeAt(list.head, 2);
        list.printList();

        // Find the palindrome of linked list
        ClassicLinkedListProblems list1 = new ClassicLinkedListProblems();
        list1.addAtTail(1);
        list1.addAtTail(2);
        list1.addAtTail(3);
        list1.addAtTail(3);
        list1.addAtTail(2);
        list1.addAtTail(1);
        System.out.println(" Is Palidrome" + list1.checkPalidrom());

    }

    private boolean  checkPalidrom() {
        /*
        1. find the mid
        2. linked list is odd or even, if add then adjust mid
        3. reverse the second half list
        4. compare the first half and second half of the linked list
         */

        Node sp = head;
        Node fp = head;
        Node mid = null;
        while(fp!= null && fp.next!=null){
            sp = sp.next;
            fp = fp.next.next;
        }
         // 1, 2, 3, 2, 1  == > (odd count ) then mid == 3, so  we need to adjust mid to mid+1 in oder to skip the 3
        // 1,2,3,3,2,1   ==> (even count) , mid remains same
        if(fp!= null){
            mid = sp.next;
        }else{
            mid = sp;
        }
        //Reverse the second half of linked list
        Node next = null;
        Node prev = null;
        while(mid!=null){
            next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }

        // Now second half head = prev
        //comparing the two linked list
        while(head!=null && prev!=null){
            if(head.data !=prev.data){
                return false;
            }else{
                head = head.next;
                prev=prev.next;
            }
        }

        return true;
    }

    /*
    move all the even indices node to end of it
    Input: head = [1,2,3,4,5]
    Output: [1,3,5,2,4]
     */
    private Node OddEvenArrange() {
        if(head == null ){
            return null;
        }
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next=evenHead;
        return head;
    }

    private void removeNode(int val) {
        Node curr = head;
        Node prev = null;
        while(curr!=null){
            if(curr.data == val){
                if(curr == head){
                    head = curr.next;
                }else{
                    prev.next = curr.next;
                }
                curr = curr.next;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
    }

    /*
        4-->1-->8-->4-->5-->Null

        Null<--4<--1<--8<--4<--5
     */
    private void reverseList() {
        Node pre = null;
        Node next = null;
        Node curr = head;
        while(curr!=null){
            next = curr.next; //take the next node
            curr.next = pre; // point to previous
            pre = curr;      // move the prev to current position
            curr = next;     //move current to next for next iteration
        }
        head = pre;
    }

    private void removeNodeAt(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy;
        Node last = dummy;
        for(int i =1;i<=n;i++){
            last = last.next;
        }
        while(last.next!=null){
            first = first.next;
            last=last.next;
        }
        first.next = first.next.next;
        head = dummy.next;
    }


}
