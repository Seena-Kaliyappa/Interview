package com.seena.practise.ds.tree.bt;

public class BinaryTreeMirror {

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
        BinaryTreeMirror mirror = new BinaryTreeMirror();

        Node root1 = mirror.createNode(2);
        root1.left = mirror.createNode(4);
        root1.right = mirror.createNode(5);
        root1.right.left = mirror.createNode(6);

        Node root2 = mirror.createNode(2);
        root2.right = mirror.createNode(4);
        root2.left = mirror.createNode(5);
        root2.left.right = mirror.createNode(6);

        System.out.println(mirror.isMirror(root1, root2));

        // Below code is to check the isophormic

        Node a = mirror.createNode(2);
        a.left = mirror.createNode(7);
        a.left.left = mirror.createNode(5);
        a.right = mirror.createNode(8);

        Node b = mirror.createNode(2);
        b.left = mirror.createNode(7);
        b.left.right = mirror.createNode(5);
        b.right = mirror.createNode(8);

        System.out.println( " Isomorphic "+mirror.isIsomorphic(a, b));
        System.out.println("Is SubTreeFind" + isSubtree(root1, root1));
    }

    private boolean isIsomorphic(Node a, Node b) {
        if(a == null && b == null ){
            return true;
        }
        if(a==null || b==null ){
            return false;
        }
        if(a.data!=b.data){
            return false;
        }
        return isIsomorphic(a.left, b.left )&& isIsomorphic(a.right, b.right ) || isIsomorphic(a.left, b.right) && isIsomorphic(a.right, b.left);
    }

    public Node createNode(int val){
        return new Node(val);
    }

    private boolean isMirror(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1== null || node2 == null){
            return false;
        }
        return node1.data == node2.data && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    private boolean isSameMirrorStructur(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1== null || node2 == null){
            return false;
        }
        return isSameMirrorStructur(node1.left, node2.right) && isSameMirrorStructur(node1.right,node2.left);
    }

    private boolean isSameTreeStructur(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1== null || node2 == null){
            return false;
        }
        return isSameTreeStructur(node1.left, node2.left) && isSameTreeStructur(node1.right,node2.right);
    }

    /*
    If Tree is foldable,then its left structure and right structure are same
     */
    private boolean isFoldable(Node root){
        if(root == null ){
            return true;
        }
        return isSameMirrorStructur(root.left, root.right);
    }

    /**
     * to find the subTree present in the main tree.
     * @param root
     * @param subRoot
     * @return
     */
    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null ) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isSameTree(Node root, Node subRoot) {
        if (root ==null && subRoot ==null){
            return true;
        }
        if (root ==null || subRoot ==null){
            return false;
        }
        return root.data == subRoot.data && isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }



}
