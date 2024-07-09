package com.seena.practise.ds.array.easy;

/**
 *Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 *
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1)Use a Hash Map
 * 2)Iterate through the smaller sized array and populate the hash map.
 * 3)For each element in the second array, check if it exists in the hash map and has a non-zero count.
 * 4)If the element from the second array exists in the hash map, add it to a result container and decrease its count in the hash map.
 * 5)If the count of an element in the hash map reaches zero, ensure it is no longer considered by removing it from the map.
 * 6)After processing all elements, return the result container containing the intersection of the two arrays.
 *
 *
 * i. can use a two-pointer technique to find the intersection which would be more efficient.
 * ii. Binary Search : Each element of the smaller sorted array within the larger sorted array, reducing the
 * search time for each element
 *
 * Q2. What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * Answer.
 * i. If nums1 is much smaller than nums2, it's more efficient to use a hash map for the smaller array and
 * iterate through the larger array.
 * ii. If sorted : Binary Search
 *
 * Q3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 * Answer.
 * Load nums1 into memory using a hash map to store frequencies, then read nums2 from disk in element by element, updating the intersection result as each chunk is processed to efficiently handle large datasets within memory limits.
 */
public class InterSectionOfTwoArraysWithDuplicates {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = intersectOfArrays(nums1, nums2);
        for (int i : res) {
            System.out.println(i);
        }
    }

    private static int[] intersectOfArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        boolean isNum1Smaller = nums1.length < nums2.length;
        if (isNum1Smaller)  {
            return process(nums1, nums2);
        } else {
            return process(nums2, nums1);
        }

    }

    private static int[] process(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // key: element, value: frequency
        List<Integer> res = new ArrayList<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                res.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
