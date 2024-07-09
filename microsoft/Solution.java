package com.seena.microsoft;

public class Solution {
    public static void main(String args[]) {
        String input = "NAANAAXNABABYNNBZ";
        System.out.println("maximum mov " + maxMove(input));
    }

    private static int maxMove(String input) {
        int count = 0;
        int aCount = 0, bCount = 0, nCount = 0;
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'A') {
                aCount++;
            }
            if (arr[i] == 'B') {
                bCount++;
            }
            if (arr[i] == 'N') {
                nCount++;
            }
            if (aCount >=3 && bCount >=1 && nCount >=2) {
                count++;
                aCount -= 3;
                bCount -= 1;
                nCount -= 2;
            }
        }
        return count;
    }
}
