package com.seena.leetcode.blind75.binary;

/**
 * Set union A | B
 * Set intersection A & B
 * Set subtraction A & ~B
 * Set negation ALL_BITS ^ A or ~A
 * Set bit A |= 1 << bit
 * Clear bit A &= ~(1 << bit)
 * Test bit (A & 1 << bit) != 0
 * Extract last bit A&-A or A&~(A-1) or x^(x&(x-1))
 * Remove last bit A&(A-1)
 * Get all 1-bits ~0
 */
public class BitWiseOperatorTest {

    public static void main(String[] args) {
        int a = 5, b=2;
       // System.out.println(a | b);
       // System.out.println(a & b);
        System.out.println(a & ~b);
       // System.out.println(~a);
       // System.out.println(a |=1 <<1);
       // System.out.println(a|b);
       // System.out.println(a|b);
       // System.out.println(a|b);
       // System.out.println(a|b);

    }
}
