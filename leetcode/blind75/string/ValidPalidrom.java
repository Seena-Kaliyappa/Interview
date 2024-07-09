package com.seena.leetcode.blind75.string;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
public class ValidPalidrom {
    public static void main(String[] args) {
       // String input = "A man, a plan, a canal: Panama";
        String input = "0P";
        System.out.println("Is valid palindrom ==> " + isValidPalindrom(input));
    }

    private static boolean isValidPalindrom(String s) {
        if (s.length() <=1) return true;

        int left =0, right = s.length()-1;
        while (left < right){
            //remove all Alphanumeric characters (alphanumeric includes letters and numbers), we should not exlude numbers.
           if (!Character.isLetterOrDigit(s.charAt(left))) {
               left++;
               continue;
           }
           if (!Character.isLetterOrDigit(s.charAt(right))) {
               right--;
               continue;
           }
           if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
               return false;
           }
           left++;
           right--;

        }

        return true;
    }
}
