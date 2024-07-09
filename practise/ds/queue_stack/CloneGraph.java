package com.seena.practise.ds.queue_stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args){
        ArrayList<Node> list = new ArrayList<>();
        list.add(new Node(3));
        list.add(new Node(2));
        Node node = new Node(5, list);
        Node clonedNode = cloneGraph(node);
    }

    private static Node cloneGraph(Node node) {
        Map<Node, Node> cache = new HashMap<>();
        return cloneGraph(node, cache);
    }

    private static Node cloneGraph ( Node node, Map<Node,Node> cache){
        if(node == null){
            return null;
        }
        if(cache.containsKey(node)){
            return cache.get(node);
        }
        Node newNode = new Node(node.val);
        cache.put(node, newNode);
        for(Node neighbour:node.neighbors){
            newNode.neighbors.add(cloneGraph(neighbour,cache));
        }

        return cache.get(node);
    }
}
