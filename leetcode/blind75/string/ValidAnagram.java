package com.seena.leetcode.blind75.string;

import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String s1 = "rat";
        String s2 = "tar";
        System.out.println("Is Strings are valid anagram ==> " +validAnagram(s1, s2));
    }

    private static boolean validAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c-'a']--;
        }
        return Arrays.stream(count).map(Math::abs).sum() == 0;
    }
}
