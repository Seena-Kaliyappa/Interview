package com.seena.practise.ds.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] input = {2,7,11,15};
        int[] result = twoSum(input, 22);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] twoSum(final int[] nums,final int target) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i =0 ; i < nums.length; i++) {
            if (res.containsKey(target - nums[i])) {
                return new int[]{res.get(target-nums[i]), i};
            }
            res.put(nums[i], i);
        }
        return new int[] {};
    }
}
