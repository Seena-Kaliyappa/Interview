package com.seena.practise.ds.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given two positive integers low and high.
 *
 * An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal to the sum of the last n digits of x. Numbers with an odd number of digits are never symmetric.
 *
 * Return the number of symmetric integers in the range [low, high].
 *
 *
 *
 * Example 1:
 *
 * Input: low = 1, high = 100
 * Output: 9
 * Explanation: There are 9 symmetric integers between 1 and 100: 11, 22, 33, 44, 55, 66, 77, 88, and 99.
 * Example 2:
 *
 * Input: low = 1200, high = 1230
 * Output: 4
 * Explanation: There are 4 symmetric integers between 1200 and 1230: 1203, 1212, 1221, and 1230.
 */
public class CountSymmetricIntegers {
    public static void main(String[] ars) {
        int low = 1200, high = 1230;
        //System.out.println("Symmetric Int count " + symmetricIntCount(low, high));
        System.out.println("Symmetric Int count " + symmetricIntCountUsingMath(low, high));
    }

    private static int symmetricIntCountUsingMath(final int low, final int high) {
        int count = 0;
        for(int i = low; i<=high; i++) {
            if ( i > 10 && i <100) { // 2 digit number, check first digit == second digit
                if (i/10 == i%10) {
                    count++;
                }
            }
            if (i > 1000 && i < 10000) { // 4 digit number, check first two digits sum == last two digits sum
                int left = i /100;
                int right = i % 100;
                if ((left/10 + left%10) == (right/10 + right%10)) {
                    count++;
                }
            }

        }
        return count;
    }


    /**
    private static int symmetricIntCount(int low, int high) {
        int count = 0;
        for(int i = low; i<=high; i++) {
            List<Integer> list = new ArrayList();
            int first =0, sec =0;
            int y = i;
            while (y !=0 ) {
                int digit = y%10;
                y = y/10;
                list.add(digit);
            }
            if ((list.size())%2 != 0) {
                continue;
            } else {
                for (int k = 0; k <list.size()/2; k++ ) {
                    first += list.get(k);
                }
                for (int j=list.size()/2; j < list.size(); j++) {
                    sec += list.get(j);
                }
            }
            if (first == sec) {
                count++;
            }
        }
        return count;
    }
     **/
}
