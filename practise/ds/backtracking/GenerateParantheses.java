package com.seena.practise.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */
public class GenerateParantheses {
    static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        int n = 3;
        generateParenthesis(0, 0, "", n);
    }

    private static void generateParenthesis(int left, int right, String s, int n) {
        if(s.length() == n*2){
            System.out.println(s);
            res.add(s);
            return;
        }
        if(left < n){
            generateParenthesis(left+1, right, s+"(", n);
        }
        if(right < left){
            generateParenthesis(left, right+1, s+")", n);
        }
    }
}
