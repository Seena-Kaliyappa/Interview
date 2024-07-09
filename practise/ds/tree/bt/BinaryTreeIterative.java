package com.seena.practise.ds.tree.bt;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeIterative {

    static class Node{
        int val;
        Node left;
        Node right;
        Node(int data){
            val = data;
            left = null;
            right = null;
        }
    }

    private static Node createNode(int data){
        return new Node(data);
    }

    public static void main(String[] args){
        Node root = createNode(5);
        root.left = createNode(3);
        root.right = createNode(7);
        root.left.left = createNode(2);
        root.left.right = createNode(4);
        root.right.left = createNode(6);
        root.right.right = createNode(8);

       List<Integer> output =  preOrder(root);
       output.stream().forEach(i-> System.out.print(" " +i));
       System.out.println();

       output = inOrder(root);
       output.stream().forEach(i-> System.out.print(" "+i));
       System.out.println();


        output = postOrder(root);
        output.stream().forEach(i-> System.out.print(" " +i));
        System.out.println();
    }

    private static List<Integer> inOrder(Node root) {
        List<Integer> output = new ArrayList<>();
        if(root == null){
            return output;
        }
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            Node node = st.pop();
            output.add(node.val);
            curr = node.right;
        }
        return output;
    }

    private static List<Integer> preOrder(Node root) {
        if (root == null ){
            return null;
        }
        List<Integer> output = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node node = st.pop();
            output.add(node.val);
            /*
            Since we are using stack,,LIFO, we need to place first right and then left..
            while poping , it will pop left node first
             */
            if(node.right!= null){
                st.push(node.right);
            }
            if(node.left!=null){
                st.push(node.left);
            }
        }
        return output;
    }

    private static List<Integer> postOrder(Node root) {
        if (root == null ){
            return null;
        }
        List<Integer> output = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node node = st.pop();
            resultStack.add(node.val);
            /*
            Since we are using stack,,LIFO, we need to place first right and then left..
            while poping , it will pop left node first
             */
            if(node.left!= null){
                st.push(node.left);
            }
            if(node.right!=null){
                st.push(node.right);
            }
        }
        while(!resultStack.isEmpty()){
            output.add(resultStack.pop());
        }
        return output;
    }
}
