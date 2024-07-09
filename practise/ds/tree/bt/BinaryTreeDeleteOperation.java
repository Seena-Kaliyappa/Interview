package com.seena.practise.ds.tree.bt;

public class BinaryTreeDeleteOperation {

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
        BinaryTreeDeleteOperation bt = new BinaryTreeDeleteOperation();
        Node root = bt.createNode(2);
        root.left = bt.createNode(7);
        root.left.left = bt.createNode(2);
        root.left.right = bt.createNode(6);
        root.left.right.left = bt.createNode(5);
        root.left.right.right = bt.createNode(11);
        root.right = bt.createNode(5);
        root.right.right = bt.createNode(9);
        root.right.right.left = bt.createNode(4);

        bt.inOrderTraversal(root);
        bt.removeAllNodesLessThanLenthK(root, 1, 4);
        System.out.println();
        bt.inOrderTraversal(root);
        System.out.println();
        System.out.println(" Removing the nodes from the path where sum is less than given  sum ");
        bt.removeAllNodesInPathIfSumIsLess(root, 0, 15);
        bt.inOrderTraversal(root);

    }
    /*
    Delete operation should be performed always with post traversal order
     */
    private Node removeAllNodesLessThanLenthK(Node node, int level, int length) {
        if(node == null ){
           return null;
        }
        node.left = removeAllNodesLessThanLenthK(node.left, level+1 , length);
        node.right = removeAllNodesLessThanLenthK(node.right, level+1, length);
         // if leaf node, and level less than specific length, then delete that node
        if(node.left == null && node.right == null && level < length){
            return null;
        }
        return node;
    }

    private Node removeAllNodesInPathIfSumIsLess(Node node, int pathSum, int sum){
        if(node == null){
            return node;
        }
        node.left = removeAllNodesInPathIfSumIsLess(node.left, pathSum+node.data , sum);
        node.right = removeAllNodesInPathIfSumIsLess(node.right, pathSum+node.data, sum);
        if(node.left == null && node.right == null && ((pathSum+node.data)< sum)){
            return null;
        }
        return node;
    }
    private void inOrderTraversal(Node node) {
        if(node ==null){
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(" " + node.data);
        inOrderTraversal(node.right);
    }

    private Node createNode(int data){
        Node node = new Node(data);
        return node;
    }

}
