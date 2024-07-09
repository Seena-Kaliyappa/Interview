package com.seena.leetcode.blind75.string;

/**
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPolidromSubString {
    static String res ="";
    public static void main(String[] args) {
        String input = "babad";

        for(int i =0; i<input.length()-1; i++) {
            longestPalindromeString(input, i, i);
            longestPalindromeString(input, i, i+1);

        }

        System.out.println("Longest palindrom string ==> " + res);
    }

    private static void longestPalindromeString(String input, int st, int end) {

        while(st >=0 && end < input.length() && input.charAt(st) == input.charAt(end)) {

            if (res.length() <= end-st) {
                res = input.substring(st, end+1);
            }
            st--;
            end++;
        }
    }
}
