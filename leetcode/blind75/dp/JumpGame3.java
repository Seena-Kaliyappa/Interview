package com.seena.leetcode.blind75.dp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation: 
 * All possible ways to reach at index 3 with value 0 are: 
 * index 5 -> index 4 -> index 1 -> index 3 
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3 
 * Example 2:
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true 
 * Explanation: 
 * One possible way to reach at index 3 with value 0 is: 
 * index 0 -> index 4 -> index 1 -> index 3
 * Example 3:
 *
 * Input: arr = [3,0,2,1,2], start = 2
 * Output: false
 * Explanation: There is no way to reach at index 1 with value 0.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 5 * 104
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 */
public class JumpGame3 {
    public static void main(String[] args) {
        int[] arr = {4,2,3,0,3,1,2};
        int start = 5;
        System.out.println(canReach(arr, start));
    }

    private static boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length == 0) return false;
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                int ptr = queue.remove();
                if (arr[ptr] == 0) {
                    return true;
                }
                int mov  = arr[ptr];
                if (ptr-mov >=0  && arr[ptr-mov] >= 0) {
                    queue.add(ptr-mov);
                }
                if (mov+ptr <arr.length && arr[ptr+mov] >= 0 ) {
                    queue.add(mov+ptr);
                }
                arr[ptr] = -1;
            }
        }
        return false;
    }

}
