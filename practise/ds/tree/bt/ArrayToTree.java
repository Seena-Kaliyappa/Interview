package com.seena.practise.ds.tree.bt;

import java.util.HashMap;
import java.util.Map;

public class ArrayToTree {

    int preOrderIndex;
    int postOrderIndex;
    Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            val = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args){
        /*
        Inorder and pre-order Array to Binary Tree
         */
        int[] inorder = {9,3,15,20,7};
        int[] preorder = {3,9,20,15,7};
        int[] postorder = {9,15,7,20,3};
        ArrayToTree tree = new ArrayToTree();

        TreeNode  bt1 = tree.buildTreeFromInorderAndPreorder(inorder,preorder);
        tree.preOrderTraversal(bt1);
        System.out.println();
        TreeNode  bt2 = tree.buildTreeFromInorderAndPostorder(inorder,postorder);
        tree.postOrderTraversal(bt2);
    }

    private void postOrderTraversal(TreeNode bt1) {
        if(bt1==null){
            return;
        }
        postOrderTraversal(bt1.left);
        postOrderTraversal(bt1.right);
        System.out.print(" "+bt1.val);

    }

    private void preOrderTraversal(TreeNode bt1) {
        if(bt1==null){
            return;
        }
        System.out.print(" "+bt1.val);
        preOrderTraversal(bt1.left);
        preOrderTraversal(bt1.right);
    }

    private TreeNode buildTreeFromInorderAndPreorder(int[] inorder, int[] preorder) {
        preOrderIndex = 0;
        for(int i=0;i<inorder.length;i++){
            inOrderIndexMap.put(inorder[i],i);
        }
        return buildTreeFromPreOrder(preorder, 0, inorder.length-1);
    }

    private TreeNode buildTreeFromPreOrder(int[] preorder, int left, int right) {
        if(left>right){
            return null;
        }
        int val = preorder[preOrderIndex];
        preOrderIndex++;
        TreeNode root = new TreeNode(val);
        root.left = buildTreeFromPreOrder(preorder, left, inOrderIndexMap.get(val)-1);
        root.right = buildTreeFromPreOrder(preorder,inOrderIndexMap.get(val)+1,right);
        return root;
    }
    private TreeNode buildTreeFromInorderAndPostorder(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length-1 ;
        for(int i=0;i<inorder.length;i++){
            inOrderIndexMap.put(inorder[i],i);
        }
        return buildTreeFromPostOrder(postorder, 0, inorder.length-1);
    }

    private TreeNode buildTreeFromPostOrder(int[] postorder, int left, int right) {
        if(left>right){
            return null;
        }
        int val = postorder[postOrderIndex];
        postOrderIndex--;
        TreeNode root = new TreeNode(val);
        root.right = buildTreeFromPostOrder(postorder,inOrderIndexMap.get(val)+1, right);
        root.left = buildTreeFromPostOrder(postorder,left, inOrderIndexMap.get(val)-1);
        return root;
    }
}
