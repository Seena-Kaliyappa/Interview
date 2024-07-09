package com.seena.practise.ds.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        System.out.println(ZigZagConvertconvert(str, 3));
    }

    private static String ZigZagConvertconvert(String s, int row) {
        if ( s.length() < row  || row == 1) return s;
        List<Character>[] rows = new ArrayList[row];
        for (int i = 0; i < row; i++) {
            rows[i] = new ArrayList<>();
        }
        int index = 0, dir = 1;
        for (Character ch : s.toCharArray()) {
            rows[index].add(ch);
            if (index == 0) {
                dir = 1;
            } else if (index == row - 1) {
                dir = -1;
            }
            index += dir;
        }
        StringBuilder res = new StringBuilder();
        for (List<Character> r : rows) {
            for (Character ch : r) {
                res.append(ch);
            }
        }
        return res.toString();
    }
}
