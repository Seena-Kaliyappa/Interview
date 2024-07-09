package com.seena.leetcode.blind75.dp;

import java.util.Arrays;

/**
 Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

 In one step, you can delete exactly one character in either string.



 Example 1:

 Input: word1 = "sea", word2 = "eat"
 Output: 2
 Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 Example 2:

 Input: word1 = "leetcode", word2 = "etco"
 Output: 4


 Constraints:

 1 <= word1.length, word2.length <= 500
 word1 and word2 consist of only lowercase English letters.
 */
public class DeleteOperationforTwoStrings {
    public static void main(String[] args) {
        final String s1 = "leetcode", s2 = "etco";
        System.out.println(minDistance(s1, s2));
    }

    private static int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <=m;i++) {
            for (int j = 1; j<=n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] +1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return m+n - (2*dp[m][n]);
    }

    private static int minDist(final String s1, final String s2) {
        int[] ch = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            ch[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i) - 'a';
            if (ch[index] > 0) {
                ch[index]--;
            } else {
                ch[index]++;
            }
        }
        return Arrays.stream(ch).sum();
    }
}
