package com.seena.practise.ds.tree.bt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

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
        BinaryTree bt = new BinaryTree();
        Node root = bt.creatNode(2);
        root.left = bt.creatNode(7);
        root.left.left = bt.creatNode(2);
        root.left.right = bt.creatNode(6);
        root.left.right.left = bt.creatNode(5);
        root.left.right.right = bt.creatNode(11);
        root.right = bt.creatNode(5);
        root.right.right = bt.creatNode(9);
        root.right.right.left = bt.creatNode(4);

        System.out.println(" In Order Traversal...");
        bt.inOrderTraversal(root);
        System.out.println();

        System.out.println(" Pre Order Traversal");
        bt.preOrderTraversal(root);
        System.out.println();


        System.out.println(" Post Order Traversal");
        bt.postOrderTraversal(root);
        System.out.println();
        //sum of value of all nodes
        System.out.println(" Sum of nodes "+ bt.sumOfAllNodeValues(root));
        //diff of of even or odd values
        System.out.println(" Difference between evnAndOdd values "+ bt.diffOfEvenAndAddLevels(root));
        //Total node count
        System.out.println(" Total number of nodes in the tree "+ bt.getTotalNodeCount(root));
        //leaf node count
        System.out.println(" Total number of leaf nodes in the tree "+ bt.getLeafNodeCount(root));
        //height of node or height of tree
        System.out.println(" Height of Tree "+bt.getMaxHeight(root));
        //height of node or height of tree
        System.out.println(" Min Height of Tree "+bt.getMinHeight(root));
        //print the element in the given level
        System.out.println(" Elelement at given level");
        bt.elementsAtLevel(root,2);
        System.out.println();

        //Recursion
        bt.elementsAtLevelOrder(root);
        System.out.println(" Reverse level order using recursion");
        bt.elementsAtLevelReverseOrder(root);
        //Non Recursive
        System.out.println(" Print element at level order without recursion");
        bt.elementAtLevelOrderWithoutRec(root);
        bt.elementAtLevelOrderWithoutRecLBL(root);
        System.out.println(" Print element at level reverse order without recursion");
        bt.elementAtLevelReverseOrderWithoutRec(root);
        System.out.println();

        // Left view of tree
        bt.leftView(root);
        System.out.println();
        bt.rightView(root);

        System.out.println(" Level of node");
        System.out.println(bt.levelOfNode(root,7,1));

        //Mirror of Tree
        System.out.println(" Mirrored Tree..");
        Node mirrorTree = bt.mirrorTree(root);
        bt.inOrderTraversal(mirrorTree);

        //Double the tree with left node
        System.out.println( " Doubled Tree..");
        bt.doubleTree(root);
        bt.inOrderTraversal(root);
    }

    private void doubleTree(Node node){
        if(node == null ){
            return ;
        }
        doubleTree(node.left);
        doubleTree(node.right);
        Node tmp = new Node(node.data);
        tmp.left = node.left;
        node.left = tmp;

    }

    private int levelOfNode(Node root, int val, int level) {
        if(root==null){
            return 0;
        }
        if(root.data==val){
            return level;
        }
        int l;
        l = levelOfNode(root.left,val,level+1);
        if(l!=0){
            return l;
        }
        l = levelOfNode(root.right,val,level+1);
        return l;
    }

    private Node mirrorTree(Node root) {
        if(root==null){
            return null;
        }
        Node t = root.left;
        root.left=root.right;
        root.right=t;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    private void rightView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root==null){
            return;
        }
        queue.add(root);
        System.out.println(" Right view of tree");
        while(true){

            int count = queue.size();
            if(count==0){
                break;
            }
            System.out.print(" "+queue.peek().data);
            while(count>0){
               Node node = queue.remove();
               if(node.right!=null){
                   queue.add(node.right);
               }
               if(node.left!=null){
                   queue.add(node.left);
               }
               count--;
            }
        }
    }

    private void leftView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        System.out.println(" Left view of tree");
        while (true){
            if(queue.peek()!= null){
                System.out.print(" "+queue.peek().data);
            }
            int count = queue.size();
            if(count == 0){
                break;
            }
            while(count>0){
                Node top = queue.remove();
                if(top.left !=null){
                    queue.add(top.left);
                }
                if(top.right!= null){
                    queue.add(top.right);
                }
                count--;
            }
        }
    }

    private void elementAtLevelReverseOrderWithoutRec(Node root) {
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Stack<Node> stack = new Stack<>();
        while(!queue.isEmpty()){
            Node top = queue.remove();
            if(top.right != null){
                queue.add(top.right);
               // stack.push(top.right);

            }
            if(top.left!=null){
                queue.add(top.left);
                //stack.push(top.left);
            }
            stack.push(top);
        }

        while(!stack.isEmpty() ){
            System.out.print(" "+stack.pop().data);
        }
    }

    private void elementAtLevelOrderWithoutRec(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root== null){
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            Node top = queue.remove();
            System.out.print(" "+top.data);
            if(top.left!=null){
                queue.add(top.left);
            }
            if(top.right!= null){
                queue.add(top.right);
            }
        }
    }

    private void elementAtLevelOrderWithoutRecLBL(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root== null){
            return;
        }
        queue.add(root);
        while(true){
            int count = queue.size();
            if(count ==0){
                break;
            }
            while(count>0){
                Node top = queue.remove();
                System.out.print(" "+top.data);
                if(top.left!=null){
                    queue.add(top.left);
                }
                if(top.right!= null){
                    queue.add(top.right);
                }
                count--;
            }
            System.out.println();
        }

    }

    private void elementsAtLevelOrder(Node root) {
        int height = getMaxHeight(root);
        for(int i=1;i<=height+1;i++){
            elementsAtLevel(root, i);
            System.out.println();
        }

        // Print in the reverse level order
        for(int i=height+1;i>=1;i--){
            elementsAtLevel(root, i);
            System.out.println();
        }

    }


    private void elementsAtLevelReverseOrder(Node root) {
        int height = getMaxHeight(root);
        // Print in the reverse level order
        for(int i=height+1;i>=1;i--){
            elementsAtLevel(root, i);
            System.out.println();
        }

    }

    private void elementsAtLevel(Node node, int level) {
        if(node == null){
            return;
        }
        if(level ==1){
            System.out.print(" "+ node.data);
            return;
        }
        elementsAtLevel(node.left,level-1);
        elementsAtLevel(node.right,level-1);

    }

    private int getMaxHeight(Node node) {
        if(node == null){
            return -1;
        }
        return max(getMaxHeight(node.left), getMaxHeight(node.right))+1;
    }

    private int max(int a, int b) {
        return a>b?a:b;
    }

    private int getMinHeight(Node node){
        if(node == null ){
            return Integer.MAX_VALUE;
        }
        if(node.left == null && node.right == null ){
            return 0;
        }
        return Math.min(getMinHeight(node.left), getMinHeight(node.right))+1;
    }
    private int min(int a , int b) {
        return a<b?a:b;
    }

    private int getLeafNodeCount(Node node) {
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right ==null){
            return 1;
        }
        return getLeafNodeCount(node.left)+getLeafNodeCount(node.right);
    }

    private int getTotalNodeCount(Node node) {
        if (node == null){
            return 0;
        }
        return 1+getTotalNodeCount(node.left)+getTotalNodeCount(node.right);
    }

    private int diffOfEvenAndAddLevels(Node node) {
        if(node == null){
            return 0;
        }
        return node.data-diffOfEvenAndAddLevels(node.left)-diffOfEvenAndAddLevels(node.right);
    }

    private int sumOfAllNodeValues(Node node) {
        if (node == null){
            return 0;
        }
        return node.data+ sumOfAllNodeValues(node.left)+ sumOfAllNodeValues(node.right);
    }

    private void postOrderTraversal(Node node) {
        if(node == null ){
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(" "+node.data);
    }

    private void preOrderTraversal(Node node) {
        if(node == null ){
            return;
        }
        System.out.print(" "+ node.data);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    private void inOrderTraversal(Node node) {
        if(node ==null){
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(" " + node.data);
        inOrderTraversal(node.right);
    }

    private Node creatNode(int data){
        Node node = new Node(data);
        return node;
    }
}
