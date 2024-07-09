package com.seena.leetcode.blind75.dp;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 */
public class PerfectSquareSum {
    static int[] dp;
    public static void main(String[] args) {
        System.out.println(numSquares(12));
      //  System.out.println(numSquares(13));
    }

    private static int numSquares(int n) {
        dp = new int[n];
        return getSquaeCount(n);
    }

    private static int getSquaeCount(int n) {
        if (n <= 3) return n;
        if (dp[n-1] != 0) return dp[n-1];
        int min = n;
        for (int i = 1; i*i <= n; i++){
            min = Math.min(min, getSquaeCount(n-i*i) +1);
        }
        dp[n-1] = min;
        return min;
    }
}
