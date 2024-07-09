package com.seena.leetcode.top150;

/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * Example 2:
 *
 * Input: nums = [5], k = 1
 * Output: 5.00000
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 */
public class MaxSubArray {
    public static void main(String[] args) {
        //int[] nums = {1,12,-5,-6,50,3};
        int[] nums = {-1};
        int k = 1;
        System.out.println("Max SubArray => " + findMaxAverage(nums, k));
    }

    private static double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i<k; i++) {
            sum += nums[i];
        }
        double maxSum = sum;
        for (int j = k; j<nums.length; j++) {
            sum -= nums[j-k];
            sum += nums[j];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum/k;
    }
}
