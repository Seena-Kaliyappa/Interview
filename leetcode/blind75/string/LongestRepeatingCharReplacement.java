package com.seena.leetcode.blind75.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 424. Longest Repeating Character Replacement
 * Medium
 * Topics
 * Companies
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 */
public class LongestRepeatingCharReplacement {
    public static void main(String[] args) {
        final String input = "AABABBA";
        System.out.println("Longest Repeating replacement count ->" + longestRepeatingCharReplacement(input, 2));
        //System.out.println("Longest Repeating replacement count ->" + longestRepeatingCharReplacement1(input, 1));
    }

    private static int longestRepeatingCharReplacement(String s, int k) {
        char[] alphabet = new char[26]; //to store the number of characters frequency
        int left = 0;
        int answer = 0;
        int maxOccuranceOfCurrChar = 0;

        for (int right = 0; right < s.length(); right++) {
            int currCharIndex = s.charAt(right) - 'A';
            alphabet[currCharIndex]++;
            maxOccuranceOfCurrChar = Math.max(maxOccuranceOfCurrChar, alphabet[currCharIndex]);

            if (right - left + 1 - maxOccuranceOfCurrChar > k) {
                alphabet[s.charAt(left) - 'A']--;
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }

    //Not working
    private static int longestRepeatingCharReplacement1(String s, int k) {
        int res = 0, start = 0, end = 0;
        int tempK = k;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while (end < s.length()) {
            if (set.contains(s.charAt(end))) {
                res = Math.max(res, end - start +1);
                end++;
            } else {
                if (tempK > 0) {
                    tempK--;
                    res = Math.max(res, end - start +1);
                    end++;
                } else {
                    set.remove(s.charAt(start));
                    set.add(s.charAt(end - k +1));
                    start = end - k -1;
                    end = start;
                    tempK = k;
                }
            }
        }
        return res;
    }


}
