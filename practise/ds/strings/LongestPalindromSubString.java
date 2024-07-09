package com.seena.practise.ds.strings;

/**
 * 5. Longest Palindromic Substring
 * Medium
 *
 * 16311
 *
 * 960
 *
 * Add to List
 *
 * Share
 * Given a string s, return the longest palindromic substring in s.
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
 */
public class LongestPalindromSubString {
    static String res = "";
    public static void main(String[] args) {
        String input = "madam1";
        res = longestPalindrome(input);
        System.out.println(" longest palindrom == >" + res);
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len <2) {
            return s;
        }
        for (int i = 0; i<len-1; i++) {
            checkPalindrom(s, i, i);
            checkPalindrom(s, i, i+1);
        }
        return res;
    }

    private static void checkPalindrom(String s, int st, int e) {
        while(st>=0 && e <s.length() && s.charAt(st) == s.charAt(e)) {
            if (res.length() <= (e-st)) {
                res = s.substring(st, e+1);
            }
            st--;
            e++;

        }
    }
}
