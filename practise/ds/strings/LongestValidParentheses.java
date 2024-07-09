package com.seena.practise.ds.strings;

import java.util.Stack;

/**
 *Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
 * substring
 * .
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = "()))";
        System.out.println(longestValidParentheses(s));
        System.out.println(longestValidPar(s));

    }

    private static int longestValidParentheses(String s) {
        Stack<Integer> stock = new Stack<>();
        stock.push(-1);
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stock.push(i);
            }else{
                stock.pop();
                if(stock.isEmpty()){
                    stock.push(i);
                }else{
                    max = Math.max(max, i - stock.peek());
                }
            }
        }
        return max;
    }


    private static int longestValidPar(String s) {
        int left = 0, right = 0, max = 0;

        //right orphan parenthesis
        for (int i = 0; i<s.length();i++){
            if (s.charAt(i) == '(') {
                left++;
            }else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left*2);
            } else if (right > left) {
                left=0;
                right=0;
            }
        }

        //left orphan parentheses
        left = 0;
        right = 0;
        for (int i =s.length()-1; i>0;i--){
            if (s.charAt(i) == '(') {
                left++;
            }else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left*2);
            } else if (left > right) {
                left=0;
                right=0;
            }
        }
        return max;
    }
}
