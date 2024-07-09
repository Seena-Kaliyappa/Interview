package com.seena.practise.ds.tree.bt;

public class BinaryTreeSequece {


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


    public static void main(String[] args) {
        BinaryTreeSequece bt = new BinaryTreeSequece();
        Node root = bt.createNode(2);
        root.left = bt.createNode(7);
        root.left.left = bt.createNode(2);
        root.left.right = bt.createNode(6);
        root.left.right.left = bt.createNode(5);
        root.left.right.right = bt.createNode(11);
        root.right = bt.createNode(5);
        root.right.right = bt.createNode(9);
        root.right.right.left = bt.createNode(4);
        int[] seq = {2,7,6,5};
       System.out.println(" is Sequenc present : " +bt.checkSequecenIsPresent(root, seq, 0));
       System.out.println();
       bt.rootToLeafPaths(root);
    }

    /*
        check if sequence exactly mathches the leaf node
        if index is greater or index is less than sequenc length (shorter or longer path with sequce value) return false
     */
    private boolean checkSequecenIsPresent(Node node, int[] seq, int index) {
        if(node == null){
            return false;
        }
        if(index>=seq.length || node.data !=seq[index]){
            return false;
        }
        if(node.left == null && node.right==null && node.data == seq[index] && index == seq.length-1){
            return true;
        }
       return  checkSequecenIsPresent(node.left, seq, index+1) || checkSequecenIsPresent(node.right, seq, index+1);
    }

        /*
    to print all the paths from root --> leaf. We need to take array which points the index to each leavel
    if we find leaf, print array from beginning to that index and
     */

    private void rootToLeafPaths(Node root){
        if(root == null){
            return;
        }
        int[] arr = new int[10];
        allPathsFromRootToLeaf(root, arr, 0);
    }

    private void allPathsFromRootToLeaf(Node node, int[] arr, int index) {
        if(node == null ){
            return;
        }
        arr[index] = node.data;
        if(node.left == null && node.right == null){
            printArray(arr, index);
        }
        allPathsFromRootToLeaf(node.left,arr,index+1);
        allPathsFromRootToLeaf(node.right, arr, index+1);
    }
    private void printArray(int[] arr, int index) {
        for(int i = 0; i<=index;i++){
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    private Node createNode(int data){
        Node node = new Node(data);
        return node;
    }
}
