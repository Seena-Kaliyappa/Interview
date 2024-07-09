package com.seena.leetcode.blind75.arrays;

import java.util.Arrays;
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
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] input = {2,7,11,15};
        int[] indicies = getSumIndicies(input, 9);
        Arrays.stream(indicies).forEach(System.out::println);
    }

    private static int[] getSumIndicies(int[] input, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<input.length ; i++) {
            if (map.containsKey(target-input[i])) {
                return new int[]{map.get(target-input[i]), i};
            }
            map.put(input[i], i);
        }
        return new int[]{};
    }
}
