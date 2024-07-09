package com.seena.practise.ds.tree.bt;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeWithHeight {
    class Node{
        int data;
        Node left;
        Node right;
        int height;

        Node(int i){
            this.data=i;
            left = null;
            right=null;
        }
    }

    public static void main(String[] args){
        BinaryTreeWithHeight bt = new BinaryTreeWithHeight();
        Node root = bt.creatNode(2);
        root.left = bt.creatNode(7);
        root.left.left = bt.creatNode(2);
        root.left.right = bt.creatNode(6);
        root.left.right.left = bt.creatNode(5);
        root.left.right.right = bt.creatNode(11);
        root.right = bt.creatNode(5);
        root.right.right = bt.creatNode(9);
        root.right.right.left = bt.creatNode(4);
        System.out.println(" Top View...");
        bt.printTopView(root);
        System.out.println();
        System.out.println("Bottom view...");
        bt.printBottomView(root);
        System.out.println();
        bt.printVertilcalOrder(root);

    }

    private void printVertilcalOrder(Node node) {
        if(node == null ){
            return;
        }
        TreeMap<Integer, List<Integer>> order = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node tmp = queue.remove();
            int height = tmp.height;
            if(order.get(height) == null){
                List list = new LinkedList();
                list.add(tmp.data);
                order.put(height,list);
            }else{
                order.get(height).add(tmp.data);
            }
            if(tmp.left != null){
                tmp.left.height = height-1;
                queue.add(tmp.left);
            }
            if(tmp.right!=null){
                tmp.right.height= height+1;
                queue.add(tmp.right);
            }
        }
        for( List list : order.values()){
            list.stream().forEachOrdered(i-> System.out.print(" "+ i));
            System.out.println();
        }
    }

    private void printBottomView(Node node) {
        if(node==null){
            return;
        }
        TreeMap<Integer, Integer> bottomView = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.remove();
            int height = temp.height;
            //overriding the column values for bottom view
            bottomView.put(height,temp.data);
            if(temp.left!=null)
            {
                temp.left.height = height-1;
                queue.add(temp.left);
            }
            if(temp.right!=null){
                temp.right.height= height+1;
                queue.add(temp.right);
            }
        }
        System.out.print(bottomView.values());
    }

    private void printTopView(Node node) {
        if(node==null){
            return;
        }
        TreeMap<Integer,Integer> topView = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node top = queue.remove();
            int height = top.height;
            //Adding only first element in the coloumn for the top view
            if(topView.get(height)==null){
                topView.put(height,top.data);
            }
            if(top.left!=null){
                top.left.height = height-1;
                queue.add(top.left);
            }
            if(top.right!=null){
                top.right.height = height+1;
                queue.add(top.right);
            }
        }
        System.out.print(topView.values());
    }

    private Node creatNode(int i) {
        Node node = new Node(i);
        return node;
    }
}
