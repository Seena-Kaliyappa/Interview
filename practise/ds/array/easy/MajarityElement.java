package com.seena.practise.ds.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajarityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        //int[] nums = {1,2,3,1};
        System.out.println("MajarityElement: " + majElement(nums));
    }

    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length/2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private static int majElement(int[] nums) {
        int count = 0, element = 0;
        for (int num:nums) {
            if (count == 0) {
                element = num;
                count =1;
            } else if (num == element) {
                count++;
            } else {
                count--;
            }
        }

        return element;
    }
}
