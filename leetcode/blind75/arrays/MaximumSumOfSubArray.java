package com.seena.leetcode.blind75.arrays;

/**
 * Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class MaximumSumOfSubArray {

    public static void main(String[] ars) {
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Sum of Max sub Array " + maxSubArraySum(input));
    }
    private static int maxSubArraySum(int[] nums) {
        int max = 0, currSum = 0;
        for (int i = 0; i<nums.length; i++) {
            if (currSum < 0) {
                //re-initialize to zero in case negative values
                currSum = 0;
            }
            currSum += nums[i];
            max = Math.max(max, currSum);
        }
        return max;
    }

}
