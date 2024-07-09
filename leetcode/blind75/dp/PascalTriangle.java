package com.seena.leetcode.blind75.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 *
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 */
public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generatePascalTriangle(5));
    }

    private static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;

        for (int i = 0; i<numRows;i++) {
            Integer[] r = new Integer[i+1];
            Arrays.fill(r, 1);
            res.add(Arrays.asList(r));
        }
        for (int row = 2; row < numRows; row++) {
            List<Integer> prev = res.get(row-1);
            List<Integer> curr = res.get(row);
            for (int col = 1; col < curr.size()-1; col++) {
                curr.set(col, prev.get(col-1) + prev.get(col));
            }
        }
        return res;
    }
}
