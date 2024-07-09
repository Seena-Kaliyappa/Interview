package com.seena.practise.ds.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.
 *
 * Return the maximum possible length of s.
 *
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All the valid concatenations are:
 * - ""
 * - "un"
 * - "iq"
 * - "ue"
 * - "uniq" ("un" + "iq")
 * - "ique" ("iq" + "ue")
 * Maximum length is 4.
 * Example 2:
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * Explanation: The only string in arr has all 26 characters.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lowercase English letters.
 */
public class MaxLengthOfConcatedString {
    public static void main(String[] args){
       // String[] input = {"abcdefghijklm","bcdefghijklmn","cdefghijklmno","defghijklmnop","efghijklmnopq","fghijklmnopqr","ghijklmnopqrs","hijklmnopqrst","ijklmnopqrstu","jklmnopqrstuv","klmnopqrstuvw","lmnopqrstuvwx","mnopqrstuvwxy","nopqrstuvwxyz","opqrstuvwxyza","pqrstuvwxyzab"};
        String[] input = {"a", "abc", "d", "de", "def"};
        System.out.println("Max Length of concated string leng " + maxLengthOfConcatedString(Arrays.asList(input)));
    }

    //Not Working
    private static int maxLengthOfConcatedString(List<String> arr) {
        StringBuilder sb = new StringBuilder();
        int[] chArray = new int[26];
        Collections.sort(arr, Comparator.comparingInt(String::length).reversed()); //sort the array based on length
        for(String s : arr) {
            char[] ch = s.toCharArray();
            StringBuilder sub = new StringBuilder();
            for(char c : ch) {
                if (chArray[c-'a'] == 0){
                    sub.append(c);
                    chArray[c-'a']++;
                } else {
                    break;
                }
            }
            if (sub.length() == s.length()) {
                sb.append(s);
            } else {
                char[] subCh = sub.toString().toCharArray();
                for (char c:subCh) {
                    chArray[c-'a']--;
                }
            }
        }
        return sb.length();
    }

}
