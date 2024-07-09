package com.seena.practise.ds.ll.dll;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyWithRandomPtr {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        if(head == null){
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        return copyRandomList(head, map);
    }

    private Node copyRandomList(Node node, Map<Node, Node> map){
        if(node == null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node copy = new Node(node.val);
        map.put(node, copy);

        copy.next = copyRandomList(node.next, map);
        copy.random = copyRandomList(node.random, map);

        return copy;
    }

    public static void main(String[] args){
        System.out.println(" hellow....");
    }
}
