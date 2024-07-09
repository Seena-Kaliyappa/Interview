package com.seena.practise.ds.array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 *
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
public class UniqueNumberOfOccurance {

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        System.out.println("Is Unique Occurance ->" + uniqueOccurrences(arr));
    }

    private static boolean uniqueOccurrences(int[] arr) {
        if (arr.length == 0) {
            return false;
        }
        Set<Integer> occ = new HashSet();
        Arrays.sort(arr);
        int low = 0, high = 0;
        int freq = 0;
        while (high < arr.length) {
            if (arr[low] == arr[high]) {
                high ++;
            } else if (arr[low] != arr[high]) {
                freq = (high-low);
                if (occ.contains(freq)) {
                    return false;
                }
                occ.add(freq);
                low = high;
            }
        }
        return true;
    }
}
