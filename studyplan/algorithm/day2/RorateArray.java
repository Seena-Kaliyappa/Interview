package com.seena.studyplan.algorithm.day2;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RorateArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = {99,-1,-100,3};
        rotate(arr1, 5);
        Arrays.stream(arr1).forEach(i ->System.out.print(" "+i));
    }

    private static void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        k = k % nums.length;
        swap(nums, nums.length-k, nums.length-1); //1,2,3,4,7,6,5
        swap(nums, 0, nums.length-k-1); //4,3,2,1,7,6,5
        swap(nums, 0, nums.length-1); //5,6,7,1,2,3,4
    }

    private static void swap(int[] nums, int i, int j) {
        while(i<=j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
