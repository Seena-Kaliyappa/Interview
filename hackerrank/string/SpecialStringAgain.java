package com.seena.hackerrank.string;

/**
 * A string is said to be a special string if either of two conditions is met:
 *
 * All of the characters are the same, e.g. aaa.
 * All characters except the middle one are the same, e.g. aadaa.
 * A special substring is any substring of a string which meets one of those criteria. Given a string, determine how many special substrings can be formed from it.
 *
 * Example
 *
 *  contains the following  special substrings: .
 *
 * Function Description
 *
 * Complete the substrCount function in the editor below.
 *
 * substrCount has the following parameter(s):
 *
 * int n: the length of string s
 * string s: a string
 * Returns
 * - int: the number of special substrings
 *
 * Input Format
 *
 * The first line contains an integer, , the length of .
 * The second line contains the string .
 *
 * Constraints
 *
 *
 * Each character of the string is a lowercase English letter, .
 *
 * Sample Input 0
 *
 * 5
 * asasd
 * Sample Output 0
 *
 * 7
 * Explanation 0
 *
 * The special palindromic substrings of  are
 *
 * Sample Input 1
 *
 * 7
 * abcbaba
 * Sample Output 1
 *
 * 10
 * Explanation 1
 *
 * The special palindromic substrings of  are
 *
 * Sample Input 2
 *
 * 4
 * aaaa
 * Sample Output 2
 *
 * 10
 * Explanation 2
 *
 * The special palindromic substrings of  are
 */
public class SpecialStringAgain {
    public static void main (String[] args) {
        String input = "abcbaba";
        System.out.println("Special string count " + substrCount(input.length(), input));
    }

    private static int substrCount(int n, String s) {
        if (s.length() == 1) return 1;
        int count = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i <=ch.length-2; i++) {
            int j = i;
            StringBuilder str = new StringBuilder();
            str.append(ch[j]);
            while(j <ch.length-1 && ch[j] == ch[j+1]) {
                str.append(ch[j+1]);
                if (str.toString().length() >1) {
                    count++;
                }
                j++;
            }
            int len = j+str.length()+2;
            if (len <= s.length() && s.substring(i, len).equals(str.toString()+ch[j+1]+str.toString())) {
                count++;
            }
        }
        return count+n;
    }
}
