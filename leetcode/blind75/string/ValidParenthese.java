package com.seena.leetcode.blind75.string;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 */
public class ValidParenthese {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println("is Valid parenthese ==> " +isValidParenthes(s));
    }

    private static boolean isValidParenthes(String str) {

        char[] ch = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c:ch) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
