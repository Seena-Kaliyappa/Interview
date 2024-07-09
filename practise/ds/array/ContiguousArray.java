package com.seena.practise.ds.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Medium
 * Topics
 * Companies
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * Example 2:
 * <p>
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */
public class ContiguousArray {

    public static void main(String[] args) {
        int[] nums = {0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1};
        System.out.println("leng of contiguousArray" + contiguousSubArray(nums));
        System.out.println("leng of contiguousArray" + contiguousSubArray2(nums));

    }

    private static int contiguousSubArray2(int[] nums) {
        int index = 0, sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            index++;
            if (num == 0) {
                sum--;
            } else {
                sum++;
            }
            if (sum == 0) {
                res = Math.max(res, index);
            }
            else if (map.containsKey(sum)) {
                res = Math.max(res, index - map.get(sum));
            } else {
                map.put(sum, index);
            }
        }
        return res;
    }

    private static int contiguousSubArray(int[] nums) {

        if (nums.length == 1) return 0;
        Map<Integer, Integer> map = new HashMap<>(); // counter vs index --> at what index counter == 0
        int res = 0, counter = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == 0) {
                counter--;
            } else {
                counter++;
            }
            if (counter == 0) {  // if all the previous elements are continuoes sub array with equal number of 1 and 0
                res = Math.max(res, i+1);
            }else if (map.containsKey(counter)) {  // if all the previous elements from the index of current counter
                // ( -1 to -1, 2 to 2 etc..) are continuoes sub array with equal number of 1 and 0
                res = Math.max(res, i-map.get(counter));
            } else {
                map.put(counter, i);
            }

        }
        return res;
    }
}
