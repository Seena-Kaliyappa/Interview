package com.seena.practise.ds.nums;

import java.util.Arrays;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 *
 * Since the result may be very large, so you need to return a string instead of an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(arr));
    }

    private static String largestNumber(int[] arr) {
        String[] strArr = new String[arr.length];
        for(int i=0; i<arr.length; i++){
            strArr[i] = String.valueOf(arr[i]);
        }
        Arrays.sort(strArr, (a,b) -> (b+a).compareTo(a+b)); // 3, 30 -> 303, 330 -> 330, 303

        if (strArr[0].equals("0")) return "0";
        return String.join("", strArr);
    }
}
