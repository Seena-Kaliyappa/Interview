package com.seena.hackerrank.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.
 *
 * Example
 *
 * This is a valid string because frequencies are .
 *
 *
 * This is a valid string because we can remove one  and have  of each character in the remaining string.
 *
 *
 * This string is not valid as we can only remove  occurrence of . That leaves character frequencies of .
 *
 * Function Description
 *
 * Complete the isValid function in the editor below.
 *
 * isValid has the following parameter(s):
 *
 * string s: a string
 * Returns
 *
 * string: either YES or NO
 * Input Format
 *
 * A single string .
 *
 * Constraints
 *
 * Each character
 * Sample Input 0
 *
 * aabbcd
 * Sample Output 0
 *
 * NO
 * Explanation 0
 *
 * Given , we would need to remove two characters, both c and d  aabb or a and b  abcd, to make it valid. We are limited to removing only one character, so  is invalid.
 *
 * Sample Input 1
 *
 * aabbccddeefghi
 * Sample Output 1
 *
 * NO
 * Explanation 1
 *
 * Frequency counts for the letters are as follows:
 *
 * {'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}
 *
 * There are two ways to make the valid string:
 *
 * Remove  characters with a frequency of : .
 * Remove  characters of frequency : .
 * Neither of these is an option.
 *
 * Sample Input 2
 *
 * abcdefghhgfedecba
 * Sample Output 2
 *
 * YES
 * Explanation 2
 *
 * All characters occur twice except for  which occurs  times. We can delete one instance of  to have a valid string.
 */
public class SherlockAndValidString {

    public static void main(String[] args) {
        String input = "abccc";
        System.out.println(" isValid " + isValidString(input));
    }

    private static String isValidString(String s) {
        // Write your code here
        Map<Character, Integer> map1 = new HashMap<>(); //char vs frequency
        for (char ch: s.toCharArray()) {
            map1.merge(ch, 1, Integer::sum);
        }
        int[] arr = map1.values().stream().mapToInt(i->i).toArray();
        Arrays.sort(arr);
        if (arr.length == 1) return "YES";
        int first = arr[0], last = arr[arr.length-1], sec = arr[1], secLast = arr[arr.length-2];
        if (first == last) return "YES";
        if (first == 1 && sec == last ) return "YES";
        if (first == secLast && last-secLast ==1) return "YES";
        return "NO";
    }
}
