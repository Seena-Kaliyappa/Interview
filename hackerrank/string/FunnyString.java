package com.seena.hackerrank.string;

public class FunnyString {
    public static void main(String[] args) {
        String s = "bcxz";
        System.out.println(funnyString(s));
    }

    private static String funnyString(String s) {
        // Write your code here
        int[] normal = new int[s.length()];
        int[] reverse = new int[s.length()];
        int len = s.length();
        for (int i = 0; i<len; i++) {
            normal[i] = s.charAt(i);
            reverse[i] = s.charAt(len-1-i);
        }

        for (int j = 0; j < len-1; j++) {
            if (Math.abs(normal[j] - normal[j+1]) != Math.abs(reverse[j]-reverse[j+1])) {
                return "Not Funny";
            }
        }
        return "Funny";
    }
}
