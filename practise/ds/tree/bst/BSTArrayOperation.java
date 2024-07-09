package com.seena.practise.ds.tree.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BSTArrayOperation {
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

    public static void main(String[] args){
        int[] arr = {5,6,2,10,22,45,7,9,1,8};
        BSTArrayOperation bst = new BSTArrayOperation();
        Node node = bst.createBSTFromArray(arr);
        bst.inOrder(node);

        Node inOrderPredessor = bst.inOrderPredessor(node, 45);
        System.out.println(" inOrderPredessor "+ ((inOrderPredessor !=null)?inOrderPredessor.val:null));
    }

    private void inOrder(Node node) {
        if(node == null ){
            return;
        }
        inOrder(node.left);
        System.out.print(" "+node.val);
        inOrder(node.right);
    }

    private Node createBSTFromArray(int[] arr) {
        Arrays.sort(arr);
        return bstFromArray(arr, 0, arr.length-1);
    }
    /*
    it is similar to binar search,, mid value we need to create node
     */

    private Node bstFromArray(int[] arr, int start, int end) {
        if(start > end ){
            return null;
        }
        int mid = (start+end)/2;
        Node node = createNode(arr[mid]);
        node.left = bstFromArray(arr, start, mid-1);
        node.right = bstFromArray(arr, mid+1, end);

        return node;
    }

    /*
    In order travelsal and keep the previous reference always. which gives the inorderPredessor
     */
    Node predessor_pre = null;
    boolean isPredessorFound = false;
    private Node inOrderPredessor(Node node, int val){
        if(node == null){
            return null;
        }
        Node l = inOrderPredessor(node.left , val);
        if(l!= null){
            return l;
        }
        if(node.val == val){
            isPredessorFound = true;
            return predessor_pre;
        }
        predessor_pre = node;
        Node r = inOrderPredessor(node.right, val);
        if(r!= null){
            return r;
        }

        return isPredessorFound?predessor_pre:null;
    }


    private List<Node> getCeilAndFloor(Node node, int val){
        if(node == null){
            return new ArrayList<>();
        }
        List<Node> list = new ArrayList<>();
        Node floor = null;
        Node ceil = null;
        while(node != null){
            if(val < node.val){ // if value is less than node value, then ceil =  node value
                ceil = node;
                node = node.left;
            }else if(val > node.val){ // if value is greater than node value,  then floor = node value
                floor = node;
                node = node.right;
            }else{
                floor=ceil=node;
                break;
            }
        }
        list.add(floor);
        list.add(ceil);
        return list;
    }

}
