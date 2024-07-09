package com.seena.studyplan.algorithm.day8dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Share
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 */
public class PopulateNextPointerInBT {
    public static void main(String[] ars) {
        Node root = new Node();
        populateNextPointerInBT(root);
    }

    private static Node populateNextPointerInBT(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            int size = queue.size();
            if (size == 0) {
                break;
            }
            while (size > 0) {
                Node node = queue.remove();
                size--;
                if (size == 0) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    static class Node{
        int val;
        Node left;
        Node right;
        Node next;
    }
}
