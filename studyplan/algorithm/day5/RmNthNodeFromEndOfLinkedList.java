package com.seena.studyplan.algorithm.day5;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 */
public class RmNthNodeFromEndOfLinkedList {
    public static void main(String[] args) {

        Node node5 = new Node(5);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node head = new Node(1, node2);

        removeNthNodeFromLast(head, 3);

       while (head != null) {
           System.out.print(" " + head.val);
           head = head.next;
       }
    }

    private static Node removeNthNodeFromLast(Node head, int n) {
        if (head == null ){
            return null;
        }
        Node dummy = new Node();
        dummy.next = head;
        Node slow = dummy;
        Node fast = dummy;
        for(int i = 1; i<=n; i++) {
            fast = fast.next;
        }
        while(fast.next != null ){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
