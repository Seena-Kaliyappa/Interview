package com.seena.practise.ds.tree.bst;

public class BST {

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

    public Node createNode(int k){
        return new Node(k);
    }

    public Node insert(Node node, int data){
        if(node == null ){
            return createNode(data);
        }
        if(data < node.val){
            node.left = insert(node.left,data);
        }else if(data > node.val){
            node.right = insert(node.right,data);
        }
        return node;
    }

    public static void main(String[] args){
        BST bst = new BST();
        Node root = null;
        root = bst.insert(root,8);
        root = bst.insert(root,3);
        root = bst.insert(root,6);
        root = bst.insert(root,10);
        root = bst.insert(root,4);
        root = bst.insert(root,7);
        root = bst.insert(root,1);
        root = bst.insert(root,14);
        root = bst.insert(root,13);
        root = bst.insert(root, 50);
        root = bst.insert(root, 15);


        bst.inOrder(root);
        System.out.println();
        System.out.println(" is Present ==>"+ bst.isPresent(root, 7));
        System.out.println(" Parent  ==>"+ bst.getParent(root, 7).val);
        System.out.println(" InOrder Parent  ==>"+ bst.inOrderParent(root, 7).val);
        System.out.println(" InOrder Successor  ==>"+ bst.inOrderSuccessor(root, 3).val); // immediate next higher value
        System.out.println(" Max value : "+ bst.getMaxValue(root));
        System.out.println(" LCA : "+ bst.LCA(root, 1, 7).val);
        System.out.println(" kth Smallest Element : "+ bst.kthSmallestElement(root, 7).val);
        System.out.println(" kth Gretest Element : "+ bst.kthLargerElement(root, 7).val);
        System.out.println(" is BST: "+ bst.isBST(root));

        Node dll = bst.convertBSTToDLL(root);
        printdll(dll);
    }

    private static void printdll(Node dll) {
        System.out.println(" Double linked list..");
        while(dll!= null){
            System.out.print(" "+dll.val);
            dll = dll.right;
        }
        System.out.println();
    }

    private void inOrder(Node node) {
        if(node == null ){
            return ;
        }
        inOrder(node.left);
        System.out.print(" "+node.val);
        inOrder(node.right);
    }

    private boolean isPresent(Node node, int val){
        if(node == null ){
            return false;
        }
        if( node.val == val){
            return true;
        }
        if(val < node.val){
            return isPresent(node.left, val);
        }else if(val > node.val){
            return isPresent(node.right, val);
        }
        return false;
    }

    private Node getParent(Node node, int val){
        if(node == null ){
            return null;
        }
        Node parent = null;
        while(node != null ){
            if( (node.left != null && node.left.val == val) || (node.right!=null && node.right.val == val)){
                parent = node;
                break;
            }
            if(val < node.val){
                node = node.left;
            }else if(val > node.val){
                node = node.right;
            }
        }

        return parent;
    }

    private Node inOrderParent(Node node, int val){
        if(node == null){
            return null;
        }
        Node inOrderParent = null;
        while(node!=null){
            if(val < node.val){
                inOrderParent = node;
                node = node.left;
            }else if(val > node.val){
                node = node.right;
            }else{
                break;
            }
        }
        return inOrderParent;
    }

    private Node inOrderSuccessor (Node node, int val){
        if(node == null){
            return null;
        }
        Node inOrderSuccessor = null;

        while(node !=null){
            if(val< node.val){
                inOrderSuccessor = node;
                node = node.left;
            }else if(val > node.val){
                node = node.right;
            }else{
                if(node.right!= null){
                    inOrderSuccessor = getSuccessor(node);
                }
                break;
            }
        }
        return inOrderSuccessor;
    }

    private Node getSuccessor(Node node) {
        if(node == null ){
            return null;
        }
        Node successor = node.right;
        while(successor.left != null){ // till the end of last left node is the next successor
            successor = successor.left;
        }
        return successor;
    }

    private int getEvenOddLevelDiff(Node node){
        if(node == null){
            return 0;
        }
        return node.val-getEvenOddLevelDiff(node.left)-getEvenOddLevelDiff(node.right);
    }

    private int getMaxValue(Node node){
        if(node == null ){
            return 0;
        }
        while(node.right!=null){
            node = node.right;
        }
        return node.val;
    }
    private int getMinValue(Node node){
        if(node == null ){
            return 0;
        }
        while(node.left!=null){
            node = node.left;
        }
        return node.val;
    }

    private Node LCA(Node node, int a, int b){
        if(node == null){
            return null;
        }
        while(node != null){
            if(node.val > a && node.val > b){
                node = node.left;
            }else if( node.val < a && node.val <b){
                node = node.right;
            }else{
                break;
            }
        }
        return node;
    }

    int index = 0;
    private Node kthSmallestElement(Node node , int k){
        if(node == null ){
            return null;
        }
        Node l = kthSmallestElement(node.left, k);
        if(l!=null){
            return l;
        }
        index++;
        if(index == k){
            return node;
        }
        Node r = kthSmallestElement(node.right, k);
        if(r != null){
            return r;
        }
        return null;
    }



    int max_index = 0;
    private Node kthLargerElement(Node node , int k){
        if(node == null ){
            return null;
        }
        Node r = kthLargerElement(node.right, k);
        if(r!=null){
            return r;
        }
        max_index++;
        if(max_index == k){
            return node;
        }
        Node l = kthLargerElement(node.left, k);
        if(l != null){
            return l;
        }
        return null;
    }

    private boolean isBST(Node node){
        if(node == null ){
            return true;
        }
        if(node.left!= null && node.left.val > node.val){
            return false;
        }

        if(node.right!= null && node.right.val < node.val){
            return false;
        }
        boolean l = isBST(node.left);
        if(!l){
            return false;
        }
        return isBST(node.right);
    }

    /**
     * Working one
     * @param root
     * @param min
     * @param max
     * @return
     */
    private boolean isBST(Node root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    /*
        take the ref of pre node, we just need to point the node.left = prev and prev.right = node

     */
    Node prev = null;
    Node head = null;
    private Node convertBSTToDLL(Node node){
        if (node == null){
            return null;
        }
        convertBSTToDLL(node.left);
        if(prev == null){
            head = node;
        }else{
            node.left = prev;
            prev.right = node;
        }
        prev = node;
        convertBSTToDLL(node.right);

        return head;
    }
}
