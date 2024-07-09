package com.seena.practise.ds.strings;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinaryString {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }

    private static String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int length1 = a.length()-1;
        int length2 = b.length()-1;
        while (length1 >=0 || length2 >=0 || carry > 0) {
            int d1 = length1 >= 0 ? a.charAt(length1)-'0' : 0;
            int d2 = length2 >= 0 ? b.charAt(length2)-'0' : 0;
            int sum = d1+d2+carry;
            res.append(sum%2);
            carry = sum/2;
            length1--;
            length2--;
        }
        return res.reverse().toString();
    }
}
