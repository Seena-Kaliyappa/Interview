package com.seena.leetcode.blind75.string;

/**
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 */
public class PolidromicSubStringCount {
    static int count = 0;
    public static void main(String[] args) {
        String input = "aaa";
        for(int i=0; i<input.length();i++) {
            polindromicSubStringCount(input, i, i);
            polindromicSubStringCount(input, i, i+1);
        }
        System.out.println("Polidrom subStringCount ==> " + count);

    }

    private static void polindromicSubStringCount(String s, int st, int end) {
        while(st>=0 && end < s.length() && s.charAt(st) == s.charAt(end)) {
            count++;
            st--;
            end++;
        }
    }
}
