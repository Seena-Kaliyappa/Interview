package com.seena.leetcode.blind75.binary;

import java.util.Arrays;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * Example 2:
 *
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 *
 * Constraints:
 *
 * 0 <= n <= 105
 */
public class CountingBits {
    public static void main(String[] args) {
        int[] res = getCountingBits(5);
        Arrays.stream(res).forEach(System.out::print);
    }

    private static int[] getCountingBits(int num) {
        int[] res = new int[num+1];
        for (int i= 0; i<=num; i++){
            int temp = i, count= 0;
            while (temp !=0) {
                temp = temp&(temp-1);
                count++;
            }
            res[i] = count;
        }

       return res;
    }
}
