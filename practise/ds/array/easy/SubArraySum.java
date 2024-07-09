package com.seena.practise.ds.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3,1,2], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class SubArraySum {

    public static void main(String[] args) {
        int[] input = {1,2,3,1,2};
        System.out.println(" sub array count " + subarraySum(input, 3));
    }


    private static int subarraySum(int[] nums, int k) {
        // HashMap to store number of subarrays
        // starting from index zero having
        // particular value of sum.
        HashMap<Integer, Integer> prevSum = new HashMap<>(); // sum, frequency
        prevSum.put(0,1);
        int count = 0;

        // Sum of elements so far.
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {

            // Add current element to sum so far.
            currSum += nums[i];
            //calculate the sum that have to be removed
            //so that we can get the desired sum

            int removeSum=currSum-k;

            //get count of occurrences of that sum that
            //have to removed and add it to res value
            if (prevSum.containsKey(removeSum))
                count += prevSum.get(removeSum);

            // Add currsum value to count of
            // different values of sum.
            prevSum.put(currSum,prevSum.getOrDefault(currSum,0)+1);
        }

        return count;
    }
}
