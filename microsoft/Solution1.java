package com.seena.microsoft;

import java.util.Arrays;

public class Solution1 {
    public static void main (String args[]) {
        int[] x = {0,3,6,5}; // {1,2,2,4,6,7}
        int[] y = {0,5, 3,2,1};
        System.out.println("maximum mov " + maxRoll(x, 1));
    }

    private static int maxRoll(int[] x, int w) {
        if (x.length == 0) return 0;
        Arrays.sort(x);
        int count = 1;
        int start = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] - start > w){
                count++;
                start = x[i];
            } else {
                continue;
            }
        }
        return count;
    }
}
