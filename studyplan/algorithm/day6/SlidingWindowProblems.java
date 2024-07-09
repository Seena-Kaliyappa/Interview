package com.seena.studyplan.algorithm.day6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class SlidingWindowProblems {

    public static void main(String[] args){
         String input = "abcabcbb";
         System.out.println(" longest substring length " + longestSubstringWithoutRepeat(input));
         System.out.println(" longest substring length with array " + longestSubstringWithoutRepeatWithArray(input));

        System.out.println(" Longest substring with k distinct char " + longestSubstringwithAtMostKDistinctChar(input, 2));
    }


    private static int longestSubstringwithAtMostKDistinctChar(String input, int k) {
        //base condition
        char[] arr = input.toCharArray();
        if(arr.length < k) {
            return arr.length;
        }
        //define pointer
        int start = 0, end = 0, max =0;
        //define table
        Map<Character, Integer> hm = new HashMap<>();
       //
        while(end < arr.length) {
            //expand window
            hm.put(arr[end], hm.getOrDefault(arr[end],0) + 1);

            //Contract window, if condition is not met
            while(hm.size() > k) {
                //decrement count by one
                hm.put(arr[start], hm.get(arr[start])-1);
                if(hm.get(arr[start]) == 0){
                  hm.remove(arr[start]);
                }
                start++;
            }
            max = Math.max(max, end-start+1);
            end++;
        }
        return max;
    }

    private static int longestSubstringWithoutRepeat(String input) {
        int start = 0, end = 0, max = 0;
        final HashSet<Character> hashSet = new HashSet<>();
        while (end < input.length()) {
            if(!hashSet.contains(input.charAt(end))) {
                hashSet.add(input.charAt(end));
                end++;
                max = Math.max(max, hashSet.size());
            } else {
                hashSet.remove(input.charAt(start));
                start++;
            }
        }
        hashSet.forEach(System.out::print);
        System.out.println();
        return max;
    }

    private static int longestSubstringWithoutRepeatWithArray(String str) {
        int  ans = 0;
        int[] count = new int[128];
        for (int l=0, r =0; r <str.length(); r++) {
            ++count[str.charAt(r)];
            while (count[str.charAt(r)] > 1) {
                --count[str.charAt(l++)];
                ans = Math.max(ans, r-l+1);
            }
        }
        return ans;
    }


    private static int longestSubstringWithoutRepeat1(String input) {
        int start = 0, end = 0, max = 0;
        final HashMap<Character, Integer> hm = new HashMap<>();
        while (end < input.length()) {
            if(!hm.containsKey(input.charAt(end))) {
                hm.put(input.charAt(end), 1);
                end++;
                max = Math.max(max, hm.size());
            } else {
                hm.remove(input.charAt(start));
                start++;
            }
        }

        return max;
    }
}
