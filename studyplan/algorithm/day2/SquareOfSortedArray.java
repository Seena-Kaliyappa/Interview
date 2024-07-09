package com.seena.studyplan.algorithm.day2;

import java.util.Arrays;

/**
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = {-10,-3,0,1,2,5,8,9,10};
 * Output: [0 1 4 9 25 64 81 100 100]
 */
public class SquareOfSortedArray {
    public static void main(String[] args) {
        int[] input = {-10,-3,0,1,2,5,8,9,10};

        int[] output = squareRootSortedArry(input);
        Arrays.stream(output).forEach(x -> System.out.print(" " +x));
    }

    private static int[] squareRootSortedArry(int[] nums) {
        int left = 0, right = nums.length-1, index = nums.length-1;
        int[] output = new int[nums.length];
        while (left <= right) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                output[index--] = nums[left] * nums[left];
                left++;
            } else if (Math.abs(nums[right]) > Math.abs(nums[left])) {
                output[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return output;
    }
}
