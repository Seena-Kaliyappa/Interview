package com.seena.leetcode.blind75.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubStringWithoutRepeatingChar {
    public static void main(String[] args) {
        final String input = "abcabcbb";
        System.out.println("Longest non repeating subString => " + longestSubStringWithoutRepeatingChar(input));
    }

    private static int longestSubStringWithoutRepeatingChar(final String input) {
        int res = 0, start = 0, end = 0;
        Set<Character> set = new HashSet<>();

        while(end < input.length()) {

            if (!set.contains(input.charAt(end))) {
                set.add(input.charAt(end));
                res = Math.max(res, set.size());
                end++;
            } else {
                set.remove(input.charAt(start));
                start++;
            }
        }
        return res;
    }
}
