package com.seena.practise.ds.strings;

import java.util.Arrays;

/**
 * Two strings are considered close if you can attain one from the other using the following operations:
 *
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "bca"
 * Output: true
 * Explanation: You can attain word2 from word1 in 2 operations.
 * Apply Operation 1: "abc" -> "acb"
 * Apply Operation 1: "acb" -> "bca"
 * Example 2:
 *
 * Input: word1 = "a", word2 = "aa"
 * Output: false
 * Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
 * Example 3:
 *
 * Input: word1 = "cabbba", word2 = "abbccc"
 * Output: true
 * Explanation: You can attain word2 from word1 in 3 operations.
 * Apply Operation 1: "cabbba" -> "caabbb"
 * Apply Operation 2: "caabbb" -> "baaccc"
 * Apply Operation 2: "baaccc" -> "abbccc"
 */
public class DetermineTwoStringsAreClose {

    public static void main(String[] args) {
       // String input1 = "uau", intput2 = "ssx";
        String input1 = "cabbba", intput2 = "abbccc";

        System.out.println("Strings are Close ->" + findStringsAreClose(input1, intput2));
    }

    private static boolean findStringsAreClose(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(final char c: s1.toCharArray()) {
            ++count1[c-'a'];
        }
        for(final char c: s2.toCharArray()) {
            ++count2[c-'a'];
        }
        // char should present in both the words otherwise we can't swap/transform
        //return false, if char is present only in one word but not in other word
        for (int i = 0; i <26 ; i ++) {
            if (count1[i] == 0 && count2[i] !=0 || count1[i] !=0 && count2[i] == 0) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);

        return Arrays.equals(count1, count2);
    }

}
