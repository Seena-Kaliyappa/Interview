package com.seena.leetcode.blind75.arrays;

import java.util.Arrays;

public class ProductOfElementsExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] output = getProductOfElementsExceptSelf(nums);
        Arrays.stream(output).forEach(System.out::println);
    }

    private static int[] getProductOfElementsExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int  prefixSum = 1, postfixSum =1;
        for (int i = 0; i<nums.length; i++) {
            res[i] = prefixSum;
            prefixSum *= nums[i];
        }
        for (int j = nums.length-1; j>=0; j--) {
            res[j] *= postfixSum;
            postfixSum *= nums[j];
        }
        return res;
    }
}
