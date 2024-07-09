package com.seena.leetcode.top150;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 */
public class IndexOfFirstOccurance {
    public static void main(String[] args) {
        System.out.println(findFirstOccuranceIndex("mississippi", "issip"));
    }

    private static int findFirstOccuranceIndex(String haystack, String needle) {
        if (haystack == null || needle == null || haystack == "" || needle == "") return -1;
        if (needle.length() > haystack.length()) return -1;

        int len = 0;
        while (len <= (haystack.length()-needle.length())) {
            int index = 0;
            while (index < needle.length() && haystack.charAt(len+index) == needle.charAt(index)) {
                index++;
                if (index == needle.length()) {
                    return len;
                }
            }
            len++;
        }

        return -1;
    }
}
