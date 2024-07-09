package com.seena.leetcode.blind75.dp;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * Example 2:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
public class HousRob2 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,5,6,2};
        System.out.println(" Max hour rob money" + houseRobMax(nums));
    }

    private static int houseRobMax(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        //from 0 to n-1
        int[] dp = new int[nums.length-1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i =2; i<nums.length-1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        //from 1 to n
        int[] dp1 = new int[nums.length];
        dp1[1] = nums[1];
        dp1[2] = Math.max(nums[1], nums[2]);
        for (int i=3; i<nums.length; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]);
        }
        return Math.max(dp[nums.length-2], dp1[nums.length-1]);
    }
}
