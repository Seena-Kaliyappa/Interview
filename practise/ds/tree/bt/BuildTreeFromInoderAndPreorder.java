package com.seena.practise.ds.tree.bt;


import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromInoderAndPreorder {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    Map<Integer, Integer> hm = new HashMap<>();
    int index=0;
    public static void main(String[] args){
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        BuildTreeFromInoderAndPreorder buildTreeFromInoderAndPostOrder = new BuildTreeFromInoderAndPreorder();
        TreeNode root = buildTreeFromInoderAndPostOrder.buildTree(inorder, postorder);
        System.out.println("Root = " + root);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i<inorder.length;i++){
            hm.put(inorder[i], i);
        }
        TreeNode root = dfs(preorder, 0, inorder.length-1);
        return root;
    }

    private TreeNode dfs(int[] preorder, int inorderStart, int inorderEnd) {
        //base conditioni
        if (inorderStart > inorderEnd) {
            return null;
        }
        //buil tree
        int value = preorder[index++];
        TreeNode node = new TreeNode(value);
        int inorderIndex = hm.get(value);
        //build left tree
        node.left = dfs(preorder, inorderStart, inorderIndex-1);
        //build right tree
        node.right = dfs(preorder, inorderIndex+1, inorderEnd);
        return node;
    }
}
