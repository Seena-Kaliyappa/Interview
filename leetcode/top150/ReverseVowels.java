package com.seena.leetcode.top150;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: s = "leetcode"
 * Output: "leotcede"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 */
public class ReverseVowels {
    public static void main (String[] args) {
        String s = "hello";
        System.out.println(" reversed String ==>" +reverseVowelString(s));
    }

    private static String reverseVowelString(String s) {
        if (s.length() ==1) return s;
        int left = 0, right = s.length()-1;
        char[] st = s.toCharArray();
        while (left < right) {
            while (!isVowel(st[left]) && left < right) {
                left++;
            }
            while (!isVowel(st[right]) && left <right) {
                right--;
            }
            char ch = st[left];
            st[left] = st[right];
            st[right] = ch;
            left++;
            right--;
        }
        return new String(st);
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch == 'A' || ch == 'E' ||  ch == 'I' || ch =='O' || ch =='U';
    }
}
