package com.seena.hackerrank.string;

import java.util.Stack;

/**
 * Reduce a string of lowercase characters in range ascii[‘a’..’z’]by doing a series of operations. In each operation, select a pair of adjacent letters that match, and delete them.
 *
 * Delete as many characters as possible using this method and return the resulting string. If the final string is empty, return Empty String
 *
 * Example.
 *
 *
 * aab shortens to b in one operation: remove the adjacent a characters.
 *
 *
 * Remove the two 'b' characters leaving 'aa'. Remove the two 'a' characters to leave ''. Return 'Empty String'.
 *
 * Function Description
 *
 * Complete the superReducedString function in the editor below.
 *
 * superReducedString has the following parameter(s):
 *
 * string s: a string to reduce
 * Returns
 *
 * string: the reduced string or Empty String
 * Input Format
 *
 * A single string, .
 *
 * Constraints
 */
public class SuperReduceString {
    public static void main(String[] args) {
        String s = "aaabccddd";
        System.out.println(superReducedString(s));
    }

    private static String superReducedString(String s) {
        Stack<Character> stack = new Stack();
        for (char ch : s.toCharArray()) {
            if (!stack.empty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        if (stack.isEmpty()) {
            return "Empty String";
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
