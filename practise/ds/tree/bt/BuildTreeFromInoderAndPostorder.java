package com.seena.practise.ds.tree.bt;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromInoderAndPostorder {

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
        BuildTreeFromInoderAndPostorder buildTreeFromInoderAndPostOrder = new BuildTreeFromInoderAndPostorder();
        TreeNode root = buildTreeFromInoderAndPostOrder.buildTree(inorder, postorder);
        System.out.println("Root = " + root);
    }

    private TreeNode buildTree(final int[] inorder, final int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        index = postorder.length-1;

        TreeNode root = dfs(postorder, 0, inorder.length-1);
        return root;
    }

    private TreeNode dfs(final int[] postorder, final int inorderStart, final int inorderEnd) {
        //base condition
        if (inorderStart > inorderEnd) {
            return null;
        }
        //build tree
        int value = postorder[index--];
        TreeNode node = new TreeNode(value);
        int inorderIndex = hm.get(value);
        //build right tree
        node.right = dfs(postorder, inorderIndex+1, inorderEnd);
        //build left tree
        node.left = dfs(postorder, inorderStart, inorderIndex-1);
        return node;
    }
}
