package com.seena.practise.ds.tree.bt;

import java.util.Arrays;
import java.util.List;

public class SerializeAndDeserialize {


    StringBuilder sb = new StringBuilder();

    class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val){
            this.data = val;
            left = null;
            right =null;
        }
    }


    public static void main(String[] args) {
        SerializeAndDeserialize bt = new SerializeAndDeserialize();
        TreeNode root = bt.creatNode(2);
        root.left = bt.creatNode(7);
        root.left.left = bt.creatNode(2);
        root.left.right = bt.creatNode(6);
        root.left.right.left = bt.creatNode(5);
        root.left.right.right = bt.creatNode(11);
        root.right = bt.creatNode(5);
        root.right.right = bt.creatNode(9);
        root.right.right.left = bt.creatNode(4);
        bt.traverseInOrder(root);
        System.out.println();
        TreeNode node = bt.deserialize(bt.serialize(root));
        bt.traverseInOrder(node);
    }

    private void traverseInOrder(TreeNode node) {
        if(node == null ){
            return;
        }
        traverseInOrder(node.left);
        System.out.print(" "+node.data);
        traverseInOrder(node.right);
    }

    private TreeNode creatNode(int i) {
        return new TreeNode(i);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null ){
            sb.append("-1 ");
            return "";
        }
        sb.append(""+root.data + " ");
        serialize(root.left);
        serialize(root.right);
        return sb.toString();
    }

    int index;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        index = 0;
        String[] ss = data.split(" ");
        List<String> list = Arrays.asList(ss);
        return dserialize(list);
    }

    private TreeNode dserialize(List<String> list){
        if(list.get(index).equals("-1")){
            index++;
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.parseInt(list.get(index++)));
        newNode.left = dserialize(list);
        newNode.right = dserialize(list);
        return newNode;
    }

}
