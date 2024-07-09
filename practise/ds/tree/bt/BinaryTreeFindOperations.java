package com.seena.practise.ds.tree.bt;

public class BinaryTreeFindOperations {


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
        BinaryTreeFindOperations bt = new BinaryTreeFindOperations();
        Node root = bt.createNode(2);
        root.left = bt.createNode(7);
        root.left.left = bt.createNode(2);
        root.left.right = bt.createNode(6);
        root.left.right.left = bt.createNode(5);
        root.left.right.right = bt.createNode(11);
        root.right = bt.createNode(5);
        root.right.right = bt.createNode(9);
        root.right.right.left = bt.createNode(4);
        bt.printAnchestors(root, 4);
        System.out.println();
        Node node = bt.getParent(root, 9);
        if(node == null ){
            System.out.println(" There is no Parent");
        }else{
            System.out.println(" Parent Node is "+ node.data);
        }

        node = bt.getSibling(root,11);
        if(node == null){
            System.out.println(" There is no siblings");
        }else{
            System.out.println(" Sibling Node is "+ node.data);
        }

        System.out.println(" Is Sibling : "+ bt.isSiblings(root, 5,11));

        Node lca = bt.lowestCommonAncestor(root,5,9);
        System.out.println(" LCA : "+lca.data);
        bt.printElementsAtKdistanceFromLeaf(root,1);
        System.out.println();
    }

    private void printElementsAtKdistanceFromLeaf(Node node, int k) {
        int[] elements = new int[10];
        boolean[] visited = new boolean[10];
        printElementsAtKdistaceFromLeafUtil(node, k, 1,elements,visited);
    }

    private void printElementsAtKdistaceFromLeafUtil(Node node, int k, int count, int[] elements, boolean[] visited) {
        if(node == null || k <0){
            return;
        }
        elements[count] = node.data;
        visited[count] = false;
        if(node.left == null && node.right == null && count-k>0 && visited[count-k] == false){
            System.out.print(" "+ elements[count-k]);
            visited[count-k] = true;
        }
        printElementsAtKdistaceFromLeafUtil(node.left,k,count+1,elements,visited);
        printElementsAtKdistaceFromLeafUtil(node.right,k,count+1,elements,visited);

    }

    private Node lowestCommonAncestor(Node node, int a, int b) {
        if(node == null){
            return null;
        }
        if(node.data == a || node.data == b){
            return node;
        }

        Node left = lowestCommonAncestor(node.left, a,b);
        Node right = lowestCommonAncestor(node.right, a, b);

        if(left!=null && right!= null){
            return node;
        }else if (left!=null && right ==null){
            return left;
        }else if(right!=null && left == null){
            return right;
        }else{
            return null;
        }
    }

    /*
    if a and b are siblings, then these nodes should be childs of given node.
     */
    private boolean isSiblings(Node node, int a, int b) {
        if(node == null  || node.data == a || node.data == b){
            return false;
        }
        if((node.left != null && node.right!=null && node.left.data == a && node.right.data == b) || (node.left != null && node.right!=null && node.left.data ==b && node.right.data ==a)){
            return true;
        }
        return isSiblings(node.left, a , b) || isSiblings(node.right, a, b);

    }

    /*
    This method is to find the sibling of given node.

     */
    private Node getSibling(Node node, int val) {
        if(node == null || node.data == val){
            return null;
        }
        if(node.left != null && node.left.data == val){
            return node.right;
        }
        if(node.right!=null && node.right.data == val){
            return node.left;
        }
        Node l = getSibling(node.left, val);
        if(l!=null){
            return l;
        }
        l = getSibling(node.right,val);
        return l;
    }

    /*
    This method is used to find the parent of given node.
    Given node can be left child or right child. so we need to compare the given node is present on either side of node.
    if present, then the current node is parent of given child node.
     */
    private Node getParent(Node node, int val) {
        if(node == null || node.data == val){
            return null;
        }
        if((node.left!=null && node.left.data == val) || (node.right!=null && node.right.data ==val) ){
            return node;
        }
        Node l = getParent(node.left, val);
        if(l!=null){
            return l;
        }
        l = getParent(node.right, val);
        return l;
    }

    private boolean printAnchestors(Node node, int val) {
        if(node == null){
            return false;
        }
        /*
        We don't need to print that value, we only need to pring anchestors. so returning true
         */
        if(node.data == val){
            return true;
        }
        if(printAnchestors(node.left, val)|| printAnchestors(node.right, val)) {
            System.out.println(node.data);
            return true; // if you don't return here, it will print only the parent, but not ancestors
        }
        return false;
    }

    private Node createNode(int i) {
        return new Node(i);
    }
}
