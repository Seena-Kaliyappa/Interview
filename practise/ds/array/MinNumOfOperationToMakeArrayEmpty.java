package com.seena.practise.ds.array;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a 0-indexed array nums consisting of positive integers.
 *
 * There are two types of operations that you can apply on the array any number of times:
 *
 * Choose two elements with equal values and delete them from the array.
 * Choose three elements with equal values and delete them from the array.
 * Return the minimum number of operations required to make the array empty, or -1 if it is not possible.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,3,2,2,4,2,3,4]
 * Output: 4
 * Explanation: We can apply the following operations to make the array empty:
 * - Apply the first operation on the elements at indices 0 and 3. The resulting array is nums = [3,3,2,4,2,3,4].
 * - Apply the first operation on the elements at indices 2 and 4. The resulting array is nums = [3,3,4,3,4].
 * - Apply the second operation on the elements at indices 0, 1, and 3. The resulting array is nums = [4,4].
 * - Apply the first operation on the elements at indices 0 and 1. The resulting array is nums = [].
 * It can be shown that we cannot make the array empty in less than 4 operations.
 * Example 2:
 *
 * Input: nums = [2,1,2,2,3,3]
 * Output: -1
 * Explanation: It is impossible to empty the array.
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 */


/**
 * 2244. Minimum Rounds to Complete All Tasks
 * You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task. In each round, you can complete either 2 or 3 tasks of the same difficulty level.
 *
 * Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.
 *
 *
 *
 * Example 1:
 *
 * Input: tasks = [2,2,3,3,2,4,4,4,4,4]
 * Output: 4
 * Explanation: To complete all the tasks, a possible plan is:
 * - In the first round, you complete 3 tasks of difficulty level 2.
 * - In the second round, you complete 2 tasks of difficulty level 3.
 * - In the third round, you complete 3 tasks of difficulty level 4.
 * - In the fourth round, you complete 2 tasks of difficulty level 4.
 * It can be shown that all the tasks cannot be completed in fewer than 4 rounds, so the answer is 4.
 * Example 2:
 *
 * Input: tasks = [2,3,3]
 * Output: -1
 * Explanation: There is only 1 task of difficulty level 2, but in each round, you can only complete either 2 or 3 tasks of the same difficulty level. Hence, you cannot complete all the tasks, and the answer is -1.
 */
public class MinNumOfOperationToMakeArrayEmpty {
    public static void main(String[] arg) {
        int[] num =  {2,3,3,2,2,4,2,3,4};
        System.out.println( " Min Number of Operation ==> " + minNumOfOperationToBecomeArrayEmpty(num));
    }

    private static int minNumOfOperationToBecomeArrayEmpty(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(final Integer num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        for (int freq : map.values()) {
            if (freq == 1) {
                return -1;
            }
           // res += (freq + 2)/3;
            res += freq/3;
            if (freq%3 >= 1) {
                res++;
            }
        }
        return res;
    }
}
