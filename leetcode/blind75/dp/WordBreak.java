package com.seena.leetcode.blind75.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
public class WordBreak {
    static Map<String, Boolean> map = new HashMap<>();
    public static void main(String[] args) {
        String str = "goalspecial";
        List<String> wordDict = Arrays.asList("go","goal","goals","special");
        System.out.println("WordBreak: " + wordBreak(str, wordDict));
    }

    private static boolean wordBreak(String str, List<String> wordDict) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (wordDict.contains(str)) {
            return true;
        }
        if (map.containsKey(str)) {
            return map.get(str);
        }
        for(int i =1; i<=str.length(); i++) {
            final String left = str.substring(0, i);
            if (wordDict.contains(left) && wordBreak(str.substring(i), wordDict)) {
                map.put(str, true);
                return true;
            }
        }
        map.put(str, false);
        return false;
    }
}
