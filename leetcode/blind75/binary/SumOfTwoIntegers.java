package com.seena.leetcode.blind75.binary;

/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *
 *
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = 2, b = 3
 * Output: 5
 *
 *
 * Constraints:
 *
 * -1000 <= a, b <= 1000
 */
public class SumOfTwoIntegers {
    public static void main(String[] args) {
        int a =3, b=2;
        System.out.println("GetSum using Bits ==> " + getSum(a, b));
    }

    private static int getSum(int a, int b) {

        /**
         while (b !=0) {
             int carry = (a&b)<<1; //11 & 10 ==> 10 ==> 100  2nd iteration 001 & 100 --> 000 --> 0000
             a = a^b;  //11 ^10 ==> 01  --> 01 ^100 ==> 101
             b = carry;
         }
         return a;
         **/
        return b==0?a:getSum(a^b, (a&b)<<1);
    }
}
