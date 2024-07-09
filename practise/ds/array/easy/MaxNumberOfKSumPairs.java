package com.seena.practise.ds.array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * You are given an integer array nums and an integer k.
 *
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 *
 * Return the maximum number of operations you can perform on the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 * Example 2:
 *
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * Explanation: Starting with nums = [3,1,3,4,3]:
 * - Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 */
public class MaxNumberOfKSumPairs {

    public static void main(String[] args) {
        int[] input = {3,1,3,4,3};
        System.out.println(" sub array count " + maxNumberOfKSumPairs(input, 6));
        int[] input2 = {1,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2};

        System.out.println(" missingIntegerGrSequentialSum " + missingIntegerGrSequentialSum(input2));
    }

    private static int missingIntegerGrSequentialSum(int[] nums) {
        if (nums.length ==0) {
            return 0;
        } else if (nums.length ==1) {
            return nums[0]+1;
        }

        int sum = nums[0];
        for (int i =0 ; i <nums.length-1; i++) {
            if (nums[i] == nums[i+1]-1 ) {
                sum += nums[i+1];
            } else {
                break;
            }
        }
        Arrays.sort(nums);
        for (int num : nums) {
            if (num == sum) {
                sum++;
            }
        }
        return sum;
    }

    private static int maxNumberOfKSumPairs(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        int low = 0, high = nums.length-1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == target) {
                count ++;
                low++;
                high--;
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }

        return count;
    }

}
