package com.seena.practise.ds.nums;

import java.util.ArrayList;
import java.util.List;

/**
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 *
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 *
 *
 *
 * Example 1:
 *
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 *
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 *
 *
 * Constraints:
 *
 * 10 <= low <= high <= 10^9
 */
public class SequentialDigits {

    public static void main(String[] args){
        int low=222, high=3345;
        List<Integer> seq = getSequentialNumbers(low, high);
        System.out.println(seq);
    }

    private static List<Integer> getSequentialNumbers(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<=9;i++){
            int num = i;
            int nextDig = i+1;

            while(num<=high && nextDig<=9) {
                num = num*10 + nextDig;
                if (num >=low && num <=high){
                    res.add(num);
                }
                nextDig++;
            }
        }
        res.sort(null);
        return res;
    }
}
