package com.seena.leetcode.blind75.arrays;

/**
 *
 Topics
 Companies
 Given an integer array nums, find a
 subarray
 that has the largest product, and return the product.

 The test cases are generated so that the answer will fit in a 32-bit integer.



 Example 1:

 Input: nums = [2,3,-2,4]
 Output: 6
 Explanation: [2,3] has the largest product 6.
 Example 2:

 Input: nums = [-2,0,-1]
 Output: 0
 Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


 Constraints:

 1 <= nums.length <= 2 * 104
 -10 <= nums[i] <= 10
 The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class MaximumProductOfSubArray {
    public static void main(String[] args) {
        int[] input = {2,3,-2,-4,-5,4};
        System.out.println("Max Product of SubArray "+ maxProductOfSubArrayWithNegativeValues(input));
        System.out.println("Max Product of SubArray Two Pointer Best Approach "+ maxProductOfSubArrayWithNegativeValuesTwoPointer(input));

    }

    private static int maxProductOfSubArrayWithNegativeValuesTwoPointer(final int[] nums) {
        int res = nums[0];
        int leftProd = 1, rightProd = 1;
        for (int i = 0; i < nums.length; i++) {
            leftProd = leftProd == 0 ? 1 : leftProd;
            rightProd = rightProd == 0 ? 1 : rightProd;
            leftProd *= nums[i];
            rightProd *= nums[nums.length - 1 - i];
            res = Math.max(res, Math.max(leftProd, rightProd));
        }

        return res;
    }

    //works only for +positive values
    private static int maxProductOfSubArray(int[] nums) {
        int max=0, currProd=1;
        for (int i =0; i<nums.length;i++) {
            currProd = currProd == 0 ? 1 : currProd;
            currProd *=nums[i];
            max = Math.max(max, currProd);
        }
        return max;
    }

    private static int maxProductOfSubArrayWithNegativeValues(final int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int minProd =nums[0] , maxProd = nums[0], res = nums[0];

        for (int i = 1; i<nums.length; i++) {
            if (nums[i] < 0 ) {
                int tmp = maxProd;
                maxProd = minProd;
                minProd = tmp;
            }
            minProd = Math.min(nums[i], minProd*nums[i]);
            maxProd = Math.max(nums[i], maxProd *nums[i]);
            res = Math.max(res, maxProd);
        }

        return res;
    }



}
