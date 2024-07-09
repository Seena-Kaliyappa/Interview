package com.seena.practise.ds.tree.bt;

import java.util.Stack;

public class BinaryTreeWithoutRec {

    class Node{
        private int data;
        private Node left;
        private Node right;

        Node(int val){
            this.data = val;
            left = null;
            right =null;
        }
    }

    public static void main(String[] args){
        BinaryTreeWithoutRec bt = new BinaryTreeWithoutRec();
        Node root = bt.creatNode(2);
        root.left = bt.creatNode(7);
        root.left.left = bt.creatNode(2);
        root.left.right = bt.creatNode(6);
        root.left.right.left = bt.creatNode(5);
        root.left.right.right = bt.creatNode(11);
        root.right = bt.creatNode(5);
        root.right.right = bt.creatNode(9);
        root.right.right.left = bt.creatNode(4);

        bt.printPreOrder(root);
        System.out.println();
        bt.printInOrder(root);
    }

    private void printInOrder(Node node) {

        if(node==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
        while(!stack.isEmpty()){
            Node tmp = stack.pop();
            System.out.print(" "+tmp.data);
            if(tmp.right!=null){
                Node t = tmp.right;
                while(t!=null){
                    stack.push(t);
                    t = t.left;
                }
            }
        }
    }

    private void printPreOrder(Node node) {
        if(node==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            Node tmp = stack.pop();
            System.out.print(" "+tmp.data);
            if(tmp.right!=null){
                stack.push(tmp.right);
            }
            if(tmp.left!=null){
                stack.push(tmp.left);
            }
        }
    }

    private Node creatNode(int data){
        Node node = new Node(data);
        return node;
    }
}
